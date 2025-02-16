# API_Venda

Construir uma API REST utilizando Java;
A API deve expor uma rota com documentação swagger (http://.../api-docs).
A API deve possuir 3 operações:

1 - Registrar venda: Recebe os dados do vendedor + itens vendidos. Registra venda com status "Aguardando pagamento";
2 - Buscar venda: Busca pelo Id da venda;
3 - Atualizar venda: Permite que seja atualizado o status da venda.

OBS.: Possíveis status: Pagamento aprovado | Enviado para transportadora | Entregue | Cancelada.
Uma venda contém informação sobre o vendedor que a efetivou, data, identificador do pedido e os itens que foram vendidos;
O vendedor deve possuir id, cpf, nome, e-mail e telefone;
A inclusão de uma venda deve possuir pelo menos 1 item;
A atualização de status deve permitir somente as seguintes transições:

De: Aguardando pagamento Para: Pagamento Aprovado

De: Aguardando pagamento Para: Cancelada

De: Pagamento Aprovado Para: Enviado para Transportadora

De: Pagamento Aprovado Para: Cancelada

De: Enviado para Transportador. Para: Entregue

A API não precisa ter mecanismos de autenticação/autorização;
A aplicação não precisa implementar os mecanismos de persistência em um banco de dados, eles podem ser persistidos "em memória".

-----------------------------------------------------
Execute a aplicação e acesse a documentação Swagger em http://localhost:8080/swagger-ui.html.
