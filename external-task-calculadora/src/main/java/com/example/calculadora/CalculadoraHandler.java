package com.example.calculadora;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

@Component//o parametro abaixo da notação abaixo é o apontamento do nosso componente.
@ExternalTaskSubscription("calculadora")
public class CalculadoraHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        //inicializando o resultado.
        long result = 0L;

        long a = externalTask.getVariable("a");
        long b = externalTask.getVariable("b");
        String operacao = externalTask.getVariable("operacao");

        switch(operacao) {
            case "soma":
                result = a + b;
                break;

            case "subtracao":
                result = a - b;
                break;

            case "multiplicacao":
                result = a * b;
                break;

            case "divisao":
                result = a / b;
                break;
        }
        /*O camunda possui uma classe estatica Variables que nos permite
        *criarmos uma mapa utilitários para criação de variáveis*/
        VariableMap variaveis = Variables.createVariables();
        variaveis.put("restultado", result);
        externalTaskService.complete(externalTask, variaveis);
    }
}
