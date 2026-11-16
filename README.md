# PULSO: Desenvolvedores em Conflito

**Missão:** colocar o painel PULSO em produção sem perder funcionalidades.

**Disciplina:** Desenvolvimento de Sistemas  
**Modalidade:** desafio prático em equipes de 2 a 4 integrantes  

Este é o documento completo da atividade: inclui o contexto, as instruções de execução, os desafios e os critérios de avaliação.

## Situação-problema

A empresa PULSO utiliza um painel web para acompanhar chamados de suporte interno. Três desenvolvedores trabalharam **em paralelo** e entregaram funcionalidades diferentes. Cada alteração funciona na sua própria branch, mas nenhuma foi integrada à versão principal. O responsável anterior tentou reunir as mudanças e percebeu que os arquivos foram modificados nos mesmos lugares.

A equipe de vocês assumiu a integração. O objetivo é **entregar uma versão funcional que mantenha todas as melhorias**, sem apagar o trabalho de nenhum desenvolvedor. Após a integração, o cliente também solicitou uma melhoria inédita.

Não basta deixar o Git aceitar o merge: **é preciso fazer o sistema funcionar com as funcionalidades combinadas**.

## O sistema recebido

O projeto inclui uma aplicação web pronta para executar, com **Java** no servidor e **HTML, CSS e JavaScript** no navegador. A aplicação exibe oito chamados de diferentes setores, prioridades e situações. Não é necessário criar um sistema do zero.

O histórico Git contém estas branches:

| Branch | Funcionalidade já desenvolvida separadamente |
|---|---|
| `main` | Versão básica do painel, sem as melhorias |
| `feature/filtros` | Filtrar chamados pelo status |
| `feature/ordenacao` | Ordenar chamados pela prioridade, da maior para a menor |
| `feature/resumo` | Exibir indicadores de quantidade total, abertos e concluídos |

**Importante:** as branches têm origem na mesma versão inicial. O que estiver pronto em uma branch ainda não estará automaticamente disponível nas outras.

## Como obter e executar o projeto

**Requisitos:** JDK 17 ou superior e Git instalado.

1. Abra o link do repositório que o professor disponibilizou no GitHub e copie a URL de clonagem (HTTPS).
2. No terminal, execute `git clone URL_DO_REPOSITORIO`, substituindo `URL_DO_REPOSITORIO` pelo endereço copiado.
3. Entre na pasta do repositório clonado e confira as branches com `git branch -a`. Devem existir `main`, `origin/feature/filtros`, `origin/feature/ordenacao` e `origin/feature/resumo` (o prefixo `origin/` identifica as branches remotas).
4. Na raiz do projeto (pasta que contém `src` e `web`), execute `executar.bat` no Windows ou `sh executar.sh` no Linux/macOS.
5. Abra `http://localhost:8766` no navegador. Para encerrar o servidor, utilize `Ctrl+C` no terminal.

Se o material tiver sido fornecido como ZIP, extraia preservando a pasta oculta `.git`, abra um terminal na raiz e siga a partir da conferência das branches. **Não execute `git init`**: o histórico já foi preparado para o desafio.

> Não abra `web/index.html` com duplo clique nem com Live Server. O front-end depende da API executada pelo servidor Java. Ao trocar de branch, encerre o servidor antes de iniciá-lo novamente.

### Estrutura do projeto

| Caminho | Responsabilidade |
|---|---|
| `src/br/edu/pulso/Servidor.java` | Servidor HTTP e rotas da API |
| `src/br/edu/pulso/ChamadoService.java` | Consultas e regras dos chamados |
| `src/br/edu/pulso/Chamado.java` | Modelo dos chamados |
| `web/index.html` | Estrutura da interface |
| `web/app.js` | Requisições e atualização dinâmica da interface |
| `web/estilos.css` | Aparência visual |

## Desafio 1 — Investigar o histórico

1. Clone o repositório disponibilizado pelo professor. Se recebeu o projeto por ZIP, extraia preservando a pasta `.git`.
2. Abra o painel pela branch `main` e observe como ele funciona.
3. Identifique as branches existentes e analise os commits e as diferenças entre elas.
4. Abra cada branch separadamente e descubra quais arquivos e funcionalidades foram modificados. Registre brevemente o que cada desenvolvedor entregou.

## Desafio 2 — Integrar o trabalho da equipe

Na branch `main`, integre **as três funcionalidades** existentes. Use merges que preservem o histórico das branches, identifique os conflitos e resolva-os analisando o funcionamento do projeto.

Ao final, o painel deve:

- Exibir a lista completa de chamados na configuração inicial.
- Filtrar chamados por status (`Aberto`, `Em andamento` ou `Concluído`).
- Ordenar por prioridade, exibindo os chamados de prioridade **Alta** antes dos de prioridade **Média**, e os de prioridade **Média** antes dos de prioridade **Baixa**.
- Permitir usar **o filtro por status e a ordenação ao mesmo tempo**.
- Exibir indicadores com os números globais de chamados (não devem mudar quando o usuário filtra a tabela).
- Continuar funcionando após atualizar a página.

Ao resolver conflitos, não remova recursos apenas para fazer o projeto compilar. Apagar uma das duas implementações não é uma solução aceitável.

## Desafio 3 — Desenvolver uma melhoria nova usando Git

O cliente solicitou um **filtro por setor** (`Administrativo`, `Infraestrutura` e `Sistemas`). Essa funcionalidade ainda **não existe** nas branches recebidas.

1. Crie uma nova branch chamada `feature/setor`, partindo da versão integrada.
2. Implemente um seletor de setor na interface.
3. Faça o JavaScript enviar esse filtro para o servidor Java.
4. Faça o Java retornar apenas os chamados pertencentes ao setor escolhido.
5. Garanta que o filtro por setor funcione **junto com status e ordenação**.
6. Registre a implementação em um commit com mensagem compreensível e integre a nova branch à `main`.

A opção “Todos os setores” deve mostrar todos os setores, respeitando os demais filtros selecionados.

## Desafio 4 — Comprovar que a integração deu certo

Verifiquem pelo menos os seguintes casos:

| Cenário | Resultado esperado |
|---|---|
| Sem filtros | Oito chamados na tabela |
| Status `Aberto` | Apenas chamados abertos |
| Ordenação por prioridade | Alta → Média → Baixa |
| Status `Aberto` + ordenação | Apenas abertos, na ordem de prioridade |
| Setor `Sistemas` + status `Concluído` | Apenas o chamado de relatório de vendas |
| Setor `Infraestrutura` + status `Aberto` + ordenação | Chamado 101 antes do 104 |
| Indicadores | Total 8, abertos 4, concluídos 2, independentemente dos filtros |

## O que entregar

- Projeto completo com código-fonte **e histórico Git preservado** (ZIP incluindo a pasta `.git`, ou link de repositório da própria equipe com os commits e branches).
- Branch `main` contendo todos os recursos integrados.
- Uma captura do histórico de commits (`git log --oneline --graph --decorate --all`) ou o arquivo `historico.txt` com esse histórico.
- Um registro curto: quais conflitos ocorreram, como foram resolvidos e quem ficou responsável por revisar cada parte.

**Não é necessário apresentar o trabalho à turma.** Cada equipe deve conseguir demonstrar o funcionamento caso o professor solicite uma verificação durante a aula.

## Critérios de avaliação

O trabalho será avaliado considerando:

- **Análise do histórico:** identificação das branches, dos commits e das alterações realizadas por cada desenvolvedor.
- **Integração das funcionalidades:** preservação dos filtros por status, da ordenação e dos indicadores, sem comprometer o funcionamento do painel.
- **Nova funcionalidade:** implementação do filtro por setor em uma branch própria, com integração à `main` e funcionamento conjunto com os outros recursos.
- **Organização do trabalho:** histórico Git compreensível e registro breve dos conflitos, das soluções e da participação da equipe.

A avaliação considera o funcionamento da aplicação e a compreensão das alterações realizadas, não apenas a execução de comandos Git.

## Referência de comandos Git

```bash
git status
git branch -a
git log --oneline --graph --decorate --all

# Com clone do GitHub: a branch remota aparece como origin/feature/filtros
git diff main..origin/feature/filtros
git switch feature/filtros
git switch main
git merge --no-ff feature/filtros

# Para conferir e registrar as alterações
git diff --check
git add .
git commit -m "mensagem descritiva"
```

Se você estiver usando o ZIP original em vez de um clone do GitHub, as branches já serão **locais**: use `git diff main..feature/filtros`. Se preferir não criar uma branch local após o clone, também é possível integrar diretamente com `git merge --no-ff origin/feature/filtros`.

Ao trocar de branch, pare o servidor Java antes de executá-lo novamente. Não use `git init`: o projeto já é um repositório Git.

Esses comandos são referências, **não uma solução pronta**. Outros comandos podem ser necessários conforme os conflitos encontrados. Cuidado ao usar comandos que descartam alterações.

**Importante:** o repositório disponibilizado pelo professor é para consulta e clonagem; não é preciso ter permissão para enviar alterações a ele. Trabalhem no clone local. Se desejarem entregar por link, publiquem a solução em um repositório da própria equipe, preservando as branches e o histórico.
