# Documentação da API

## Não precisar de autenticação:

#### Criação do primeiro usuário do sistema

Ao registrar um usuário, a endpoint bloquear e registrar sempre como administrador.

```http
  POST /usuario/create/first
```

| Parâmetro(JSON) | Tipo      | Descrição                                                 |
| :-------------- | :-------- | :-------------------------------------------------------- |
| `nomeDeUsuario` | `string`  | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`  | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean` | **Obrigatório**. Se conta vai ter funções administrativas |



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

| Parâmetro(JSON)  | Tipo     | Descrição                                            |
| :--------------- | :------- | :--------------------------------------------------- |
| `idPaciente`     | `long`   | **Obrigatório**. Passar o id do paciente             |
| `idDentista`     | `long`   | **Obrigatório**. Passar o id do dentista             |
| `inicioConsulta` | `string` | **Obrigatório**. Passar a data de inicio da consulta |
| `fimConsulta`    | `string` | **Obrigatório**. Passar a data de fim da consulta    |

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

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id da consulta |

#### Alterar uma busca de consulta pelo id da consulta

A consulta deve existir para que se possa alterar a busca pela consulta do id.

```http
PUT /consulta/{id}
```

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id da consulta |


| Parâmetro(JSON)  | Tipo     | Descrição                                            |
| :--------------- | :------- | :--------------------------------------------------- |
| `idPaciente`     | `long`   | **Obrigatório**. Passar o id do paciente             |
| `idDentista`     | `long`   | **Obrigatório**. Passar o id do dentista             |
| `inicioConsulta` | `string` | **Obrigatório**. Passar a data de inicio da consulta |
| `fimConsulta`    | `string` | **Obrigatório**. Passar a data de fim da consulta    |

#### Deletar uma consulta pelo id da consulta

A consulta deve existir para que se possa deletar a consulta

```http
DELETE /consulta/{id}
```

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id da consulta |

#### Fazer uma busca de consulta pelo id do paciente

Filtrar as consultas e retornar uma lista de consultas de um paciente especifico.

```http
  GET /consulta/paciente/{id}
```

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca de consulta pelo id do dentista

Filtrar as consultas e retornar uma lista de consultas de um dentista especifico.

```http
  GET /consulta/dentista/{id}
```

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do dentista |


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

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do paciente |

#### Fazer uma busca de paciente pelo nome e sobrenome

Buscar por um paciente pelo seu nome e sobrenome.

```http
  GET /paciente/search?nome=x&&sobrenome=y
```

| Parâmetro           | Tipo     | Descrição                                                    |
| :------------------ | :------- | :----------------------------------------------------------- |
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

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do dentista |

#### Fazer uma busca de dentista pelo nome e sobrenome

Buscando o dentista pelo seu nome e sobrenome.

```http
  GET /dentista/search?nome=x&&sobrenome=y
```

| Parâmetro           | Tipo     | Descrição                                                    |
| :------------------ | :------- | :----------------------------------------------------------- |
| `nome`, `sobrenome` | `String` | **Obrigatório**. Passar o nome e sobrenome como parâmetros pela URI |

## Precisa está logado e o nível de permissão é de administrador

### Usuário

#### Criar um novo usuário

```http
  POST /usuario/create
```

| Parâmetro(JSON) | Tipo      | Descrição                                                 |
| :-------------- | :-------- | :-------------------------------------------------------- |
| `nomeDeUsuario` | `string`  | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`  | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean` | **Obrigatório**. Se conta vai ter funções administrativas |

#### Modificar dados de um usuário específico

```http
  PUT /usuario/{ID}
```

| Parâmetro | Tipo   | Descrição                               |
| :-------- | :----- | :-------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do usuário |


| Parâmetro(JSON) | Tipo      | Descrição                                                 |
| :-------------- | :-------- | :-------------------------------------------------------- |
| `nomeDeUsuario` | `string`  | **Obrigatório**. O nome de usuário da conta               |
| `senha`         | `string`  | **Obrigatório**. A senha da conta                         |
| `admin`         | `boolean` | **Obrigatório**. Se conta vai ter funções administrativas |

#### Obter dados de um usuário específico

O id do usuário dever existir.

```http
  GET /usuario/{ID}
```

| Parâmetro | Tipo   | Descrição                               |
| :-------- | :----- | :-------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do usuário |

#### Excluir um usuário específico

O id do usuário dever existir.

```http
  DELETE /usuario/{ID}
```

| Parâmetro | Tipo   | Descrição                               |
| :-------- | :----- | :-------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do usuário |



### Dentista

#### Criar um novo dentista

```http
  POST /dentista/create
```

| Parâmetro(JSON) | Tipo     | Descrição                                |
| :-------------- | :------- | :--------------------------------------- |
| `nome`          | `string` | **Obrigatório**. O nome do dentista      |
| `sobrenome`     | `string` | **Obrigatório**. O sobrenome do dentista |
| `cro`           | `String` | **Obrigatório**. O CRO do dentista       |

#### Modificar dados de um dentista específico

```http
  PUT /dentista/{ID}
```

| Parâmetro    | Tipo   | Descrição                                |
| :----------- | :----- | :--------------------------------------- |
| `idDentista` | `long` | **Obrigatório**. Passar o id do dentista |


| Parâmetro(JSON) | Tipo     | Descrição                                |
| :-------------- | :------- | :--------------------------------------- |
| `nome`          | `string` | **Obrigatório**. O nome do dentista      |
| `sobrenome`     | `string` | **Obrigatório**. O sobrenome do dentista |
| `cro`           | `String` | **Obrigatório**. O CRO do dentista       |

#### Obter dados de um dentista específico

O id do dentista dever existir.

```http
  GET /dentista/{ID}
```

| Parâmetro    | Tipo   | Descrição                                |
| :----------- | :----- | :--------------------------------------- |
| `idDentista` | `long` | **Obrigatório**. Passar o id do dentista |

#### Excluir um dentista específico

O id do dentista dever existir.

```http
  DELETE /dentista/{ID}
```

| Parâmetro    | Tipo   | Descrição                                |
| :----------- | :----- | :--------------------------------------- |
| `idDentista` | `long` | **Obrigatório**. Passar o id do dentista |



### Paciente

#### Criar um novo paciente

```http
  POST /paciente/create
```

| Parâmetro(JSON) | Tipo     | Descrição                                |
| :-------------- | :------- | :--------------------------------------- |
| `nome`          | `string` | **Obrigatório**. O nome do paciente      |
| `sobrenome`     | `string` | **Obrigatório**. O sobrenome do paciente |
| `endereco`      | `Object` | **Obrigatório**. O endereço do paciente  |
| `rg`            | `String` | **Obrigatório**. O rg do paciente        |

| Parâmetro Endereço (JSON) | Tipo     | Descrição                                          |
| :------------------------ | :------- | :------------------------------------------------- |
| `idEndereco`              | `long`   | **Obrigatório**. O id do endereço                  |
| `complemento`             | `string` | **Obrigatório**. O complemento do endereço         |
| `rua`                     | `String` | **Obrigatório**. A rua do endereço                 |
| `numero`                  | `String` | **Obrigatório**. O número do endereço              |
| `bairro`                  | `String` | **Obrigatório**. O número do endereço              |
| `cidade`                  | `String` | **Obrigatório**. A cidade do endereço              |
| `estado`                  | `String` | **Obrigatório**. O estado do endereço              |
| `pontoDeReferencia`       | `String` | **Obrigatório**. O ponto de referência do endereço |

#### 

#### Modificar dados de um paciente específico

```http
  PUT /paciente/{ID}
```

| Parâmetro | Tipo   | Descrição                                |
| :-------- | :----- | :--------------------------------------- |
| `id`      | `long` | **Obrigatório**. Passar o id do paciente |


| Parâmetro(JSON) | Tipo     | Descrição                                |
| :-------------- | :------- | :--------------------------------------- |
| `nome`          | `string` | **Obrigatório**. O nome do paciente      |
| `sobrenome`     | `string` | **Obrigatório**. O sobrenome do paciente |
| `endereco`      | `String` | **Obrigatório**. O endereço do paciente  |
| `rg`            | `String` | **Obrigatório**. O rg do paciente        |

#### Obter dados de um paciente específico

O id do paciente dever existir.

```http
  GET /paciente/{ID}
```

| Parâmetro    | Tipo   | Descrição                                |
| :----------- | :----- | :--------------------------------------- |
| `idPaciente` | `long` | **Obrigatório**. Passar o id do paciente |

#### Excluir um paciente específico

O id do paciente dever existir.

```http
  DELETE /paciente/{ID}
```

| Parâmetro    | Tipo   | Descrição                                |
| :----------- | :----- | :--------------------------------------- |
| `idPaciente` | `long` | **Obrigatório**. Passar o id do paciente |

