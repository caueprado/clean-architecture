package com.ada.cleanarchitecture.controller.request;

public class ClienteAcessaContaRequest {

    private Integer id;
    private String documento;
    private String senha;

    public ClienteAcessaContaRequest(String documento, String senha) {
        this.documento = documento;
        this.senha = senha;
    }

    public ClienteAcessaContaRequest(Integer id, String documento, String senha) {
        this.id = id;
        this.documento = documento;
        this.senha = senha;
    }

    public ClienteAcessaContaRequest() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
