package br.com.mecanicadoisirmaos.controle.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

public class ServicoValidation implements Validator{

	public boolean supports(Class<?> clazz) {
		return ServicoVo.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	}

}