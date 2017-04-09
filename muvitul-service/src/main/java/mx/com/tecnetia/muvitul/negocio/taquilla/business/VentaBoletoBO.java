package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.BoletoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ImpuestoXTicketTaquillaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
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

	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {

		int cantidadBoletos = 0;
		BigDecimal total = new BigDecimal(0);
		BigDecimal descuento = new BigDecimal(0);
		BigDecimal porcentajes = new BigDecimal(0);
		BigDecimal impuestos = new BigDecimal(0);
		BigDecimal subtotal = new BigDecimal(0);

		BigDecimal subtTot = new BigDecimal(0);

		List<ImpuestoBoleto> impuestosBoletos = impuestoBoletoDAO.findByIdCine(ventaVO.getIdCine());

		for (BoletoXTicketVO boletoXTicketVO : ventaVO.getBoletosXTicketVO()) {
			cantidadBoletos = cantidadBoletos + boletoXTicketVO.getCantidad();
			total = total.add(boletoXTicketVO.getImporte());
		}

		for (PromocionXTicketVO promocionXTicketVO : ventaVO.getPromocionesXTicketVO()) {
			descuento = descuento.add(promocionXTicketVO.getImporte());
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {
			porcentajes = porcentajes.add(impuestoBoleto.getPorcentaje());
		}

		porcentajes = porcentajes.divide(new BigDecimal(100));

		impuestos = impuestos.add(total);
		impuestos = impuestos.subtract(descuento);
		impuestos = impuestos.multiply(porcentajes);

		subtotal = subtotal.add(total);
		subtotal = subtotal.subtract(descuento);
		subtotal = subtotal.subtract(impuestos);

		subtTot = subtTot.add(total);
		subtTot = subtTot.subtract(descuento);

		logger.info("Total: [{}] Descuento:[{}] Importes:[{}] Porcentajes:[{}] Subtotal:[{}]", total.toString(),
				descuento.toString(), impuestos.toString(), porcentajes.toString(), subtotal.toString());

		TicketVenta ticketVenta = ticketVentaDAO
				.save(TicketVentaAssembler.getTicketVenta(ventaVO.getIdUsuario(), ventaVO.getIdPuntoVenta(), descuento, subtotal, total));

		List<BoletosXTicket> boletosXTicket = BoletoXTicketAssembler.getBoletosXTicket(ventaVO.getBoletosXTicketVO(),
				ticketVenta);
		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletoXTicketDAO.save(boletoXTicket);
		}

		List<PromocionesXTicket> promocionesXTicket = PromocionXTicketAssembler
				.getPromocionesXTicket(ventaVO.getPromocionesXTicketVO(), ticketVenta);
		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionXTicketDAO.save(promocionXTicket);
		}

		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO(), ticketVenta);
		for (Pago pago : pagos) {
			pagoDAO.save(pago);
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {

			BigDecimal porcentaje = new BigDecimal(0);
			porcentaje = porcentaje.add(impuestoBoleto.getPorcentaje());
			porcentaje = porcentaje.divide(new BigDecimal(100));

			BigDecimal impuesto = new BigDecimal(0);
			impuesto = impuesto.add(subtTot);
			impuesto = impuesto.multiply(porcentaje);

			ImpuestosXTicketTaquilla impuestosXTicketTaquilla = ImpuestoXTicketTaquillaAssembler
					.getImpuestosXTicketTaquilla(impuestoBoleto.getIdImpuestoBoleto(), ticketVenta, impuesto);
			impuestosXTicketTaquillaDAO.save(impuestosXTicketTaquilla);
		}

		ExistenciaBoletos existenciaBoletos = existenciaBoletoDAO.findByIdProgramacion(
				ventaVO.getBoletosXTicketVO().get(0).getProgramacionVO().getIdProgramacion(),
				ventaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
		if (existenciaBoletos != null) {
			existenciaBoletos.setBoletosReservados(existenciaBoletos.getBoletosReservados() - cantidadBoletos);
			existenciaBoletoDAO.update(existenciaBoletos);
		}

		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

}
