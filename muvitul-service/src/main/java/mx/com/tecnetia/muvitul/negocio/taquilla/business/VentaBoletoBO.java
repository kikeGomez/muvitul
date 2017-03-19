package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.BoletosXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestoBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketTaquillaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionesXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.BoletoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@Service
@Transactional
public class VentaBoletoBO {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private BoletosXTicketDAOI boletoXTicketDAO;

	@Autowired
	private PromocionesXTicketDAOI promocionXTicketDAO;

	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;

	@Autowired
	private ImpuestosXTicketTaquillaDAOI impuestosXTicketTaquillaDAO;

	@Autowired
	private ImpuestoBoletoDAOI impuestoBoletoDAO;

	public Object createVenta(VentaVO ventaVO, UsuarioFirmadoVO usuarioVO) throws BusinessGlobalException {
		PuntoVenta puntoVenta = new PuntoVenta();
		puntoVenta.setIdPuntoVenta(3);
		BigDecimal total = new BigDecimal(0);
		BigDecimal descuento = new BigDecimal(0);
		BigDecimal importes = new BigDecimal(0);
		BigDecimal porcentajes = new BigDecimal(0);

		BigDecimal importe = new BigDecimal(0);
		
		List<ImpuestoBoleto> impuestosBoletos = impuestoBoletoDAO.findByIdCine(usuarioVO.getCineVO().getIdCine());

		for (BoletoXTicketVO boletoXTicketVO : ventaVO.getBoletosXTicketVO()) {
			total.add(boletoXTicketVO.getImporte());
		}

		for (PromocionXTicketVO promocionXTicketVO : ventaVO.getPromocionesXTicketVO()) {
			descuento.add(promocionXTicketVO.getImporte());
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {
			porcentajes.add(impuestoBoleto.getPorcentaje());
		}

		porcentajes.divide(new BigDecimal(100));
		importes.add(total).subtract(descuento).multiply(porcentajes);
		importe.add(total).subtract(descuento);
		
		logger.info("Total: [{}] Descuento:[{}] Importe:[{}] Porcentaje:[{}]", total.toString(), descuento.toString(),
				importes.toString(), porcentajes.toString());

		TicketVenta ticketVenta = ticketVentaDAO
				.save(TicketVentaAssembler.getTicketVenta(usuarioVO, puntoVenta, descuento, importes, total));

		List<BoletosXTicket> boletosXTicket = BoletoXTicketAssembler.getBoletosXTicket(ventaVO.getBoletosXTicketVO());
		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletoXTicket.setTicketVenta(ticketVenta);
			boletoXTicketDAO.save(boletoXTicket);
		}

		List<PromocionesXTicket> promocionesXTicket = PromocionXTicketAssembler
				.getPromocionesXTicket(ventaVO.getPromocionesXTicketVO());
		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionXTicket.setTicketVenta(ticketVenta);
			promocionXTicketDAO.save(promocionXTicket);
		}

		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO());
		for (Pago pago : pagos) {
			pago.setTicketVenta(ticketVenta);
			pagoDAO.save(pago);
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {
			ImpuestosXTicketTaquilla impuestosXTicketTaquilla = new ImpuestosXTicketTaquilla();
			impuestosXTicketTaquilla.setImpuestoBoleto(impuestoBoleto);
			impuestosXTicketTaquilla.setTicketVenta(ticketVenta);
			
			BigDecimal porcentajeBoleto = new BigDecimal(0);
			porcentajeBoleto.add(impuestoBoleto.getPorcentaje());
			porcentajeBoleto.divide(new BigDecimal(100));
			
			BigDecimal importeBoleto = new BigDecimal(0);
			importeBoleto.add(importe).multiply(importeBoleto);
			impuestosXTicketTaquilla.setImporte(importeBoleto);
			impuestosXTicketTaquillaDAO.update(impuestosXTicketTaquilla);
		}

		ExistenciaBoletos existenciaBoletos = existenciaBoletoDAO.findByIdProgramacion(
				ventaVO.getBoletosXTicketVO().get(0).getPagramacionVO().getIdProgramacion(),
				ventaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
		existenciaBoletos.setBoletosReservados(ventaVO.getBoletosXTicketVO().size());
		existenciaBoletoDAO.update(existenciaBoletos);

		return ventaVO;
	}

}
