package br.ufc.banco.service.Funcionario;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Funcionario;
import br.ufc.banco.domain.Gestor;
import br.ufc.banco.domain.Usuario;
import br.ufc.banco.domain.enumareted.Cargos;
import br.ufc.banco.repository.BancoRepository;
import br.ufc.banco.repository.FuncionarioRepository;
import br.ufc.banco.repository.GestorRepository;
import br.ufc.banco.repository.UsuarioRepository;
import br.ufc.banco.service.PessoaDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final GestorRepository gestorRepository;
    private final BancoRepository bancoRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository,
                                  UsuarioRepository usuarioRepository,
                                  GestorRepository gestorRepository,
                                  BancoRepository bancoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.gestorRepository = gestorRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    public Page<Funcionario> listarFuncionarios(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return funcionarioRepository.findAll(pageable);
    }

    @Override
    public Funcionario adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        Usuario usuario = usuarioRepository
                .findById(funcionarioDTO.usuarioId())
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado, tente novamente."));
        System.out.println(usuario);
        if (!usuario.getCargos().equals(Cargos.Doador)) {
            Funcionario funcionario = new Funcionario(
                    funcionarioDTO.nome(),
                    funcionarioDTO.tipoSangue(),
                    funcionarioDTO.cpf(),
                    funcionarioDTO.telefone(),
                    funcionarioDTO.dataNascimento(),
                    funcionarioDTO.naturalidade(),
                    funcionarioDTO.endereco(),
                    funcionarioDTO.salario(),
                    funcionarioDTO.setor(),
                    funcionarioDTO.dataAdmissao(),
                    usuario
            );
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Não autorizado. Doador não pode ser atribuido a funcionário.");
        }
    }


    @Override
    public Funcionario editarFuncionario(FuncionarioDTO funcionarioDTO) {
        return null;
    }

    @Override
    public void excluirFuncionario(Long funcionarioId) {
        funcionarioRepository.deleteById(funcionarioId);
    }

    @Override
    public void atribuirGestor(GestorDTO gestorDTO) {
        Banco banco = bancoRepository.findById(gestorDTO.bancoId()).orElseThrow(
                () -> new NoSuchElementException("Banco nâo está registrado.")
        );
        Funcionario funcionario = funcionarioRepository.findById(gestorDTO.funcionarioId()).orElseThrow(
                () -> new NoSuchElementException("Funcionario nâo está registrado.")
        );
        Gestor gestor = new Gestor(funcionario, banco);
        banco.setGestor(gestor);
        gestorRepository.save(gestor);
        bancoRepository.save(banco);
    }


}
