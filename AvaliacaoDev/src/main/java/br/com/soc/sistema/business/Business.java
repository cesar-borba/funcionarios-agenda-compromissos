package br.com.soc.sistema.business;

public interface Business {
	
	String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um n\\u00famero!";
	String ERRO_AO_BUSCAR_FUNCIONARIOS = "Erro ao buscar funcion\\u00e1rios!";
	String NOME_NAO_PODE_SER_EM_BRANCO = "Nome n\\u00e3o pode ser em branco!";
	String VALORES_NAO_PODEM_SER_NULOS = "Valores n\\u00e3o podem ser nulos!";
	String ERRO_ATUALIZACAO_REGISTRO = "N\\u00e3o foi poss\\u00edvel realizar a atualiza\\u00e7\\u00e3o do registro.";
	String ERRO_INCLUSAO_REGISTRO = "N\\u00e3o foi poss\\u00edvel realizar a inclus\\u00e3o do registro.";
	String ERRO_EXCLUSAO_REGISTRO = "N\\u00e3o foi poss\\u00edvel realizar a exclus\\u00e3o do registro.";
	String AGENDA_POSSUI_COMPROMISSOS_VINCULADOS = "A agenda possui compromissos vinculados!";
	String AGENDA_MANHA_NAO_POSSUI_DISPONIBILIDADE = "A agenda selecionada atende somente no p\\u00e9riodo da manh\\u00e3.";
	String AGENDA_TARDE_NAO_POSSUI_DISPONIBILIDADE = "A agenda selecionada atende somente no p\\u00e9riodo da tarde.";
	String ERRO_AO_BUSCAR_COMPROMISSOS = "Ocorreu um erro na busca dos compromissos.";
	String ERRO_AO_BUSCAR_COMPROMISSO = "Ocorreu um erro na busca pelo compromisso.";
	String ERRO_EMISSAO_RELATORIO = "Ocorreu um erro durante a emiss\\u00e3o do relat\\u00f3rio.s";
}