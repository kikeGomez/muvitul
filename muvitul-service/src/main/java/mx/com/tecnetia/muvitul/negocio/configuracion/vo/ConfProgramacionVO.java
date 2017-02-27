package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.List;

import mx.com.tecnetia.muvitul.negocio.taquilla.vo.FormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.SalaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VersionVO;

public class ConfProgramacionVO {
	private List<SalaVO> salasVO;
	private List<DiaVO> diasVO;
	private List<PeliculaVO> peliculasVO;
	private List<FormatoVO> formatosVO;
	private List<VersionVO> versionesVO;
	public List<SalaVO> getSalasVO() {
		return salasVO;
	}
	public void setSalasVO(List<SalaVO> salasVO) {
		this.salasVO = salasVO;
	}
	public List<DiaVO> getDiasVO() {
		return diasVO;
	}
	public void setDiasVO(List<DiaVO> diasVO) {
		this.diasVO = diasVO;
	}
	public List<PeliculaVO> getPeliculasVO() {
		return peliculasVO;
	}
	public void setPeliculasVO(List<PeliculaVO> peliculasVO) {
		this.peliculasVO = peliculasVO;
	}
	public List<FormatoVO> getFormatosVO() {
		return formatosVO;
	}
	public void setFormatosVO(List<FormatoVO> formatosVO) {
		this.formatosVO = formatosVO;
	}
	public List<VersionVO> getVersionesVO() {
		return versionesVO;
	}
	public void setVersionesVO(List<VersionVO> versionesVO) {
		this.versionesVO = versionesVO;
	}
	
}
