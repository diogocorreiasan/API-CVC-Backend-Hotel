package br.com.cvc.exceptionhandler;

public enum ProblemType {

	INCOMPREHENSIBLE_MENSAGE("Incomprehensible message"),
	ERRO_BUSINESS("Business rule violation");
	
	private String title;
	
	ProblemType( String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
