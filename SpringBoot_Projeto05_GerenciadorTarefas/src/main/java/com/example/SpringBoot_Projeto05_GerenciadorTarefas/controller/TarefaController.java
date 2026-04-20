package com.example.SpringBoot_Projeto05_GerenciadorTarefas.controller;

import com.example.SpringBoot_Projeto05_GerenciadorTarefas.model.Tarefa;
import com.example.SpringBoot_Projeto05_GerenciadorTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TarefaController
{
    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/tarefas/salvar")
    public String salvarTarefa(@RequestParam String descricao, @RequestParam Long usuarioId)
    {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setDescricao(descricao);
        novaTarefa.setUsuarioId(usuarioId);

        tarefaRepository.save(novaTarefa);

        // Redireciona de volta para a dashboard passando o ID para carregar as tarefas
        return "redirect:/dashboard?id=" + usuarioId;
    }

    @PostMapping("/tarefas/excluir")
    public String excluirTarefa(@RequestParam Long tarefaId, @RequestParam Long usuarioId)
    {
        tarefaRepository.deleteById(tarefaId);

        return "redirect:/dashboard?id=" + usuarioId;
    }
}
