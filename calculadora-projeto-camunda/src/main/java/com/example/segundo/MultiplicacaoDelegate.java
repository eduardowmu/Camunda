package com.example.segundo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MultiplicacaoDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        /*  var a = execution.getVariable("a")
            var b = execution.getVariable("b")

            execution.setVariable("resultado", a + b)

            Praticamente os mesmos scripts feito no camunda, porém o
            execution.getVariable() retorna um tipo Object.
        */

        var a = (Long)execution.getVariable("a");
        var b = (Long)execution.getVariable("b");

        execution.setVariable("resultado", a * b);
    }
}
