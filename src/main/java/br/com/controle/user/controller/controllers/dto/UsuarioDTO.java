package br.com.controle.user.controller.controllers.dto;

import br.com.controle.user.controller.domain.model.Usuario;

public record UsuarioDTO(Long id, String givenName, String surname, String nuCPF, String nuRG) {

    public UsuarioDTO(Usuario model) {
        this(model.getId(),model.getGivenName(), model.getSurname(), model.getNuCPF(), model.getNuRG());
    }

    public Usuario toModel() {
        Usuario model = new Usuario();
        model.setGivenName(this.givenName);
        model.setSurname(this.surname);
        model.setNuCPF(this.nuCPF);
        model.setNuRG(this.nuRG);
        return model;
    }
}
