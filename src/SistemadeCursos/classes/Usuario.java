package SistemadeCursos.classes;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nomeUsuario;
	private String email;
	private String senha;
	private int matricula;
	private int cpf;
	
	
	public Usuario(String nomeUsuario, String email, String senha, int matricula, int cpf) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.matricula = matricula;
		this.cpf = cpf;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return cpf == other.cpf && Objects.equals(email, other.email) && matricula == other.matricula;
	}
	@Override
	public String toString() {
		return "Pessoa [nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + ", matricula="
				+ matricula + ", cpf=" + cpf + "]";
	}
	
	
	
	
}
