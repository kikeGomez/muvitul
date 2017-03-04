package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.Date;

public class ProgramacionVO {
	private Integer idProgramacion;
	private FormatoVO formatoVO;
//	private Pelicula pelicula;
	private SalaVO salaVO;
	private VersionVO versionVO;
	private String diaSemana;
	private Date horario;
	private Date fechaVigencia;
//	private Set<ExistenciaBoletos> existenciaBoletoses = new HashSet<ExistenciaBoletos>(0);
//	private Set<BoletosXTicket> boletosXTickets = new HashSet<BoletosXTicket>(0);
	
	public Integer getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public FormatoVO getFormatoVO() {
		return formatoVO;
	}
	public void setFormatoVO(FormatoVO formatoVO) {
		this.formatoVO = formatoVO;
	}
	public SalaVO getSalaVO() {
		return salaVO;
	}
	public void setSalaVO(SalaVO salaVO) {
		this.salaVO = salaVO;
	}
	public VersionVO getVersionVO() {
		return versionVO;
	}
	public void setVersionVO(VersionVO versionVO) {
		this.versionVO = versionVO;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
}
