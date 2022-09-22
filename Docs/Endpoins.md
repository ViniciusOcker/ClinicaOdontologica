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


Faltar da documentação:
USER:
    GET /consulta/
    GET /consulta/{ID}
    PUT /consulta/{ID}
    DELETE /consulta/{ID}
    GET /consulta/paciente/{ID}
    GET /consulta/dentista/{ID}
    GET /dentista/
    GET /dentista/{ID}
    GET /dentista/search?nome=x&&sobrenome=y
    GET /paciente/
    GET /paciente/{ID}
    GET /dentista/search?nome=x&&sobrenome=y
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
