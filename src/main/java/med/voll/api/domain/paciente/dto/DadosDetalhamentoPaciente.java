package med.voll.api.domain.paciente.dto;

import med.voll.api.domain.endereco.entity.Endereco;
import med.voll.api.domain.paciente.entity.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }


}
