# PULSO — Central de chamados

Sistema web local em **Java 17+ / HTML / CSS / JavaScript**, sem bibliotecas externas.

## Executar

1. Extraia o ZIP mantendo a pasta `.git` (oculta em alguns sistemas).
2. Abra **um terminal na pasta raiz** do projeto (a que contém `web` e `src`).
3. Windows: execute `executar.bat`. Linux/macOS: `sh executar.sh`.
4. Acesse `http://localhost:8766` no navegador.
5. Encerre com `Ctrl+C` no terminal.

> Não execute `index.html` com duplo clique nem por Live Server: o front-end depende da API Java.

## Código

- `src/br/edu/pulso/Servidor.java`: servidor HTTP e rotas.
- `src/br/edu/pulso/ChamadoService.java`: lista de chamados e regras de consulta.
- `src/br/edu/pulso/Chamado.java`: modelo de dados.
- `web/index.html`: interface.
- `web/app.js`: carregamento e renderização.
- `web/estilos.css`: estilos.

## Atenção: este projeto contém histórico Git

A branch `main` é a versão básica da aplicação. As branches `feature/filtros`, `feature/ordenacao` e `feature/resumo` simulam alterações recebidas de colegas que trabalharam em paralelo. Elas **não foram integradas**. A atividade é revisar, integrar, resolver conflitos e expandir o sistema, conforme o enunciado.

Confira com `git status` e `git branch -a`. Não execute `git init` no projeto extraído, pois apagaria o contexto pedagógico da integração.

Se o Git disser que o repositório não foi encontrado, provavelmente o programa de extração não preservou a pasta oculta `.git`.
