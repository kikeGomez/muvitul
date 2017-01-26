package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;



public class AuditMessageProcessorBO implements AuditMessageProcessorBOI
{

    private AuditAssemblerMessageBOI auditAssemblerMessageBO;
	private AuditSaveMessageBOI auditSaveMessageBO;
	
    public void processMessage(AuditoriaMetodoMessageVO metodoMessageVO)
    {	AuditoriaObjeto auditoriaObjecto = this.auditAssemblerMessageBO.convertMessageVO(metodoMessageVO);
        
        this.auditSaveMessageBO.guardarAuditoria(auditoriaObjecto);
    }

	public void setAuditAssemblerMessageBO(
			AuditAssemblerMessageBOI auditAssemblerMessageBO) {
		this.auditAssemblerMessageBO = auditAssemblerMessageBO;
	}

	public void setAuditSaveMessageBO(AuditSaveMessageBOI auditSaveMessageBO) {
		this.auditSaveMessageBO = auditSaveMessageBO;
	}

    
}
