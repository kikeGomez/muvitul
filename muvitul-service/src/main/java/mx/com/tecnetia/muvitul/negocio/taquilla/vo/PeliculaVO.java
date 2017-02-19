package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.HashSet;
import java.util.Set;

public class PeliculaVO {
	private Integer idPelicula;
	private CineVO cineVO;

	public CineVO getCineVO() {
		return cineVO;
	}

	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}

	// private Distribuidora distribuidora;
	// private Pais pais;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private boolean activo;
	private Set<ProgramacionVO> espanol = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> ingles = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> subtitulado = new HashSet<ProgramacionVO>();

	public void addProgramacion(ProgramacionVO programacionVO) {
		switch (programacionVO.getVersionVO().getIdVersion()) {
		case 1:
			espanol.add(programacionVO);
			break;
		case 2:
			subtitulado.add(programacionVO);
			break;
		default:
			ingles.add(programacionVO);
			break;
		}
	}

	public Set<ProgramacionVO> getEspanol() {
		return espanol;
	}

	public void setEspanol(Set<ProgramacionVO> espanol) {
		this.espanol = espanol;
	}

	public Set<ProgramacionVO> getIngles() {
		return ingles;
	}

	public void setIngles(Set<ProgramacionVO> ingles) {
		this.ingles = ingles;
	}

	public Set<ProgramacionVO> getSubtitulado() {
		return subtitulado;
	}

	public void setSubtitulado(Set<ProgramacionVO> subtitulado) {
		this.subtitulado = subtitulado;
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
