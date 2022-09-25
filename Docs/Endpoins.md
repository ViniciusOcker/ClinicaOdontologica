# Documentação da API

## Não precisar de autenticação:

#### Criação do primeiro usuário do sistema
Ao registrar um usuário, a endpoint bloquear e registrar sempre como administrador.

```http
  POST /usuario/create/first
```
| Parâmetro(JSON) | Tipo       | Descrição                                                  |
| :---------------| :--------- | :----------------------------------------------------------|
| `nomeDeUsuario` | `string`   | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`   | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean`  | **Obrigatório**. Se conta vai ter funções administrativas |



## Precisar está logado e o nível de permissão é de usuário

#### Criar um novo usuário
```http
  POST /usuario/create
```
| Parâmetro(JSON) | Tipo       | Descrição                                                  |
| :---------------| :--------- | :----------------------------------------------------------|
| `nomeDeUsuario` | `string`   | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`   | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean`  | **Obrigatório**. Se conta vai ter funções administrativas |



## Consulta

#### Criar um nova consulta

O paciente e dentista dever existir antes de pode criar uma nova consulta

Formato das datas dever ser : dd/mm/yyyy hh:mm:ss

dd -> O dia do mês consulta

mm -> O mês da consulta

yyyy ->O  ano da consulta

hh -> a hora da consulta

mm -> O minuto da consulta

ss -> O segundo da consulta

```http
  POST /consulta/create
```
| Parâmetro(JSON)  | Tipo       | Descrição                                                  |
| :----------------| :--------- | :----------------------------------------------------------|
| `idPaciente`     | `long`     | **Obrigatório**. Passar o id do paciente                   |
| `idDentista`     | `long`     | **Obrigatório**. Passar o id do dentista                   |
| `inicioConsulta` | `string`   | **Obrigatório**. Passar a data de inicio da consulta       |
| `fimConsulta`    | `string`   | **Obrigatório**. Passar a data de fim da consulta          |  

#### Fazer uma consulta geral

O paciente e dentista devem existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/
```

#### Fazer uma busca de consulta pelo id da consulta

A consulta deve existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idConsulta`    | `long` | **Obrigatório**. Passar o id da consulta |

#### Alterar uma busca de consulta pelo id da consulta

A consulta deve existir para que se possa alterar a busca pela consulta do id.

```http
PUT /consulta/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idConsulta`    | `long` | **Obrigatório**. Passar o id da consulta |

#### Deletar uma consulta pelo id da consulta

A consulta deve existir para que se possa deletar a consulta

```http
DELETE /consulta/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idConsulta`    | `long` | **Obrigatório**. Passar o id da consulta |

#### Fazer uma busca de consulta pelo id do paciente

O paciente e dentista devem existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/paciente/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idPaciente`    | `long` | **Obrigatório**. Passar o id do paciente |



## Pacientes

#### Fazer uma busca de paciente pelo id

O paciente deve existir para que se possa fazer a consulta pelo seu id.

```http
  GET /paciente/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idPaciente`    | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca geral de pacientes

Os pacientes devem existir na base de dados.

```http
  GET /paciente/
```

#### Fazer uma busca de paciente pelo nome e sobrenome

O dentista deve existir para que se possa fazer a consulta pelo id. Sua consulta é feita passando os dados como parâmetros na URI.

```http
  GET /dentista/search?nome=x&&sobrenome=y
```

| Parâmetro(JSON)     | Tipo     | Descrição                                                    |
| :------------------ | :------- | :----------------------------------------------------------- |
| `nome`, `sobrenome` | `String` | **Obrigatório**. Passar o nome e sobrenome como parâmetros pela URI |



## Dentistas

#### Fazer uma busca de consulta pelo id do dentista

O dentista e a consulta devem existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/dentista/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idPaciente`    | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca geral de dentistas

Os dentistas devem existir na base de dados.

```http
  GET /paciente/
```

#### Fazer uma busca de dentista pelo id

O dentista deve existir para que se possa fazer a consulta pelo id.

```http
  GET /paciente/{id}
```

| Parâmetro(JSON) | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `idPaciente`    | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca de dentista pelo nome e sobrenome

O dentista deve existir para que se possa fazer a consulta pelo id. Sua consulta é feita passando os dados como parâmetros na URI.

```http
  GET /paciente/search?nome=x&&sobrenome=y
```

| Parâmetro(JSON)     | Tipo     | Descrição                                                    |
| :------------------ | :------- | :----------------------------------------------------------- |
| `nome`, `sobrenome` | `String` | **Obrigatório**. Passar o nome e sobrenome como parâmetros pela URI |



Faltar da documentação:
USER:
    ~~GET /consulta/~~
    ~~GET /consulta/{ID}~~
    ~~PUT /consulta/{ID}~~
    ~~DELETE /consulta/{ID}~~
    ~~GET /consulta/paciente/{ID}~~
    ~~GET /consulta/dentista/{ID}~~
    ~~GET /dentista/~~
    ~~GET /dentista/{ID}~~
    ~~GET /dentista/search?nome=x&&sobrenome=y~~
    ~~GET /paciente/~~~~
    ~~GET /paciente/{ID}~~
    ~~GET /dentista/search?nome=x&&sobrenome=y~~~~
ADMIN:
    POST /dentista/create
    PUT /dentista/{ID}
    DELETE /dentista/{ID}
    POST /paciente/create
    PUT /paciente/{ID}
    DELETE /paciente/{ID}
    GET /usuario/{ID}
    PUT /usuario/{ID}
    DELETE /usuario/{ID}
    GET /usuario/
