package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.RecursoVO;

public interface RecursoIbatisDAOI {
		
	@Select("select "
			+ " id_recurso,nombre,recurso_url,activo,permitir_a_todos " +
		    " from recurso "+
		    " where activo=#{activo} "+
			    " and "+
			    " case "+
			    " when substring(rtrim(recurso_url),len(recurso_url)-1,2) = '**' "+ 
			    " then "+
				    " convert( "+
				    " varchar(200), "+
				    " charindex( "+
				    " substring(rtrim(recurso_url),0,len(recurso_url)-1) "+
				    " ,#{url}) "+
				    " ) "+
			    " else "+
						" recurso_url "+
					" end "+
					" = "+
					" case "+ 
					" when substring(rtrim(recurso_url),len(recurso_url)-1,2) = '**' "+
						" then "+
							" 	'1' "+
							" else "+
							" #{url} "+ 
					" end")
	@Results(value = {
	@Result(property="idRecurso", column="id_recurso"),	
	@Result(property="nombre", column="nombre"),
	@Result(property="url", column="recurso_url"),
	@Result(property="permitirATodos", column="permitir_a_todos"),
	@Result(property="activo", column="activo")
	})
	RecursoVO getRecursoPorUrl(@Param("url")String url, @Param("activo")boolean activo);
		
}
