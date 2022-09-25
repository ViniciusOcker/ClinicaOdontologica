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

### Consulta

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

Retornar a lista de consultas.

```http
  GET /consulta/
```

#### Fazer uma busca de consulta pelo id da consulta

A consulta deve existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/{id}
```

| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id da consulta |

#### Alterar uma busca de consulta pelo id da consulta

A consulta deve existir para que se possa alterar a busca pela consulta do id.

```http
PUT /consulta/{id}
```

| Parâmetro        | Tipo       | Descrição                                                  |
| :--------------- | :--------- | :--------------------------------------------------------- |
| `id`             | `long`     | **Obrigatório**. Passar o id da consulta                   |


| Parâmetro(JSON)  | Tipo       | Descrição                                                  |
| :----------------| :--------- | :----------------------------------------------------------|
| `idPaciente`     | `long`     | **Obrigatório**. Passar o id do paciente                   |
| `idDentista`     | `long`     | **Obrigatório**. Passar o id do dentista                   |
| `inicioConsulta` | `string`   | **Obrigatório**. Passar a data de inicio da consulta       |
| `fimConsulta`    | `string`   | **Obrigatório**. Passar a data de fim da consulta          |  

#### Deletar uma consulta pelo id da consulta

A consulta deve existir para que se possa deletar a consulta

```http
DELETE /consulta/{id}
```

| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id da consulta |

#### Fazer uma busca de consulta pelo id do paciente

O paciente e dentista devem existir para que se possa fazer a consulta pelo id.

```http
  GET /consulta/paciente/{id}
```

| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca de consulta pelo id do dentista

Filtrae as consultas e retornar lista de consultas de um um dentista especifico.

```http
  GET /consulta/dentista/{id}
```
| Parâmetro        | Tipo   | Descrição                                |
| :--------------- | :----- | :--------------------------------------- |
| `id`             | `long` | **Obrigatório**. Passar o id do dentista |


### Pacientes

#### Fazer uma busca geral de pacientes

Os pacientes devem existir na base de dados.

```http
  GET /paciente/
```

#### Fazer uma busca de paciente pelo id

O paciente deve existir para que se possa fazer a consulta pelo seu id.

```http
  GET /paciente/{id}
```

| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca de paciente pelo nome e sobrenome

Buscar por um paciente pelo seu nome e sobrenome.

```http
  GET /paciente/search?nome=x&&sobrenome=y
```

| Parâmetro           | Tipo     | Descrição                                                           |
| :------------------ | :------- | :------------------------------------------------------------------ |
| `nome`, `sobrenome` | `String` | **Obrigatório**. Passar o nome e sobrenome como parâmetros pela URI |

### Dentistas

#### Fazer uma busca geral de dentistas

Os dentistas devem existir na base de dados.

```http
  GET /dentista/
```

#### Fazer uma busca de dentista pelo id

O dentista deve existir para que se possa fazer a consulta pelo id.

```http
  GET /dentista/{id}
```

| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id do dentista |

#### Fazer uma busca de dentista pelo nome e sobrenome

Buscando o dentista pelo seu nome e sobrenome.

```http
  GET /dentista/search?nome=x&&sobrenome=y
```

| Parâmetro           | Tipo     | Descrição                                                           |
| :------------------ | :------- | :------------------------------------------------------------------ |
| `nome`, `sobrenome` | `String` | **Obrigatório**. Passar o nome e sobrenome como parâmetros pela URI |

## Precisar está logado e o nível de permissão é de administrador

### Usuário

#### Criar um novo usuário
```http
  POST /usuario/create
```
| Parâmetro(JSON) | Tipo       | Descrição                                                  |
| :---------------| :--------- | :----------------------------------------------------------|
| `nomeDeUsuario` | `string`   | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`   | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean`  | **Obrigatório**. Se conta vai ter funções administrativas |

#### Modificar dados de um usuário especifico
```http
  PUT /usuario/{ID}
```
| Parâmetro       | Tipo       | Descrição                                                  |
| :-------------- | :--------- | :--------------------------------------------------------- |
| `id`            | `long`     | **Obrigatório**. Passar o id do usuário                    |


| Parâmetro(JSON) | Tipo       | Descrição                                                  |
| :---------------| :--------- | :----------------------------------------------------------|
| `nomeDeUsuario` | `string`   | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`   | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean`  | **Obrigatório**. Se conta vai ter funções administrativas |

#### Obter dados de usuário especifico
O id do usuário dever existir.
```http
  GET /usuario/{ID}
```
| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id do usuário  |
#### Excluir um usuário especifico
O id do usuário dever existir.
```http
  DELETE /usuario/{ID}
```
| Parâmetro       | Tipo   | Descrição                                |
| :-------------- | :----- | :--------------------------------------- |
| `id`            | `long` | **Obrigatório**. Passar o id do usuário |


Faltar da documentação:
ADMIN:
    POST /dentista/create
    PUT /dentista/{ID}
    DELETE /dentista/{ID}
    POST /paciente/create
    PUT /paciente/{ID}
    DELETE /paciente/{ID}
    PUT /usuario/{ID}
    DELETE /usuario/{ID}
    GET /usuario/
