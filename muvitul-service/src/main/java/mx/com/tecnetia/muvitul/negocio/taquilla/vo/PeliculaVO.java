package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.HashSet;
import java.util.Set;

public class PeliculaVO {
	private Integer idPelicula;
	private CineVO cineVO;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private boolean activo;
	private byte[] icono;
	// private Distribuidora distribuidora;
	// private Pais pais;
	
	private Set<ProgramacionVO> esp2d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> esp3d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> esp4d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> sub2d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> sub3d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> sub4d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> else2d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> else3d = new HashSet<ProgramacionVO>();
	private Set<ProgramacionVO> else4d = new HashSet<ProgramacionVO>();
	
	public void addProgramacion(ProgramacionVO programacionVO) {
		switch (programacionVO.getVersionVO().getIdVersion()) {
		case 1:
			switch (programacionVO.getFormatoVO().getNombre()) {
				case "4D": esp4d.add(programacionVO); break;
				case "3D": esp3d.add(programacionVO); break;
				default: esp2d.add(programacionVO); break;
			}
			break;
		case 2:
			switch (programacionVO.getFormatoVO().getNombre()) {
				case "4D": sub4d.add(programacionVO); break;
				case "3D": sub3d.add(programacionVO); break;
				default: sub2d.add(programacionVO); break;
			} break;
		default:
			switch (programacionVO.getFormatoVO().getNombre()) {
				case "4D": else4d.add(programacionVO); break;
				case "3D": else3d.add(programacionVO); break;
				default: else2d.add(programacionVO); break;
			} break;
		}
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
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
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	public Set<ProgramacionVO> getEsp2d() {
		return esp2d;
	}
	public void setEsp2d(Set<ProgramacionVO> esp2d) {
		this.esp2d = esp2d;
	}
	public Set<ProgramacionVO> getEsp3d() {
		return esp3d;
	}
	public void setEsp3d(Set<ProgramacionVO> esp3d) {
		this.esp3d = esp3d;
	}
	public Set<ProgramacionVO> getEsp4d() {
		return esp4d;
	}
	public void setEsp4d(Set<ProgramacionVO> esp4d) {
		this.esp4d = esp4d;
	}
	public Set<ProgramacionVO> getSub2d() {
		return sub2d;
	}
	public void setSub2d(Set<ProgramacionVO> sub2d) {
		this.sub2d = sub2d;
	}
	public Set<ProgramacionVO> getSub3d() {
		return sub3d;
	}
	public void setSub3d(Set<ProgramacionVO> sub3d) {
		this.sub3d = sub3d;
	}
	public Set<ProgramacionVO> getSub4d() {
		return sub4d;
	}
	public void setSub4d(Set<ProgramacionVO> sub4d) {
		this.sub4d = sub4d;
	}
	public Set<ProgramacionVO> getElse2d() {
		return else2d;
	}
	public void setElse2d(Set<ProgramacionVO> else2d) {
		this.else2d = else2d;
	}
	public Set<ProgramacionVO> getElse3d() {
		return else3d;
	}
	public void setElse3d(Set<ProgramacionVO> else3d) {
		this.else3d = else3d;
	}
	public Set<ProgramacionVO> getElse4d() {
		return else4d;
	}
	public void setElse4d(Set<ProgramacionVO> else4d) {
		this.else4d = else4d;
	}
}
