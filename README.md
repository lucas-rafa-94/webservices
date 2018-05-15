# WebServicesJob

O trabalho webservice, consiste na persistência de dados de 3 tabelas, essas presentes em um banco Mongodb instanciado no mLab. O desenvolvimento da camada de exposição REST e negócio foi feito via Java usando a tecnologia Spring Boot e está "deployada" no heroku atendendo o endpoint https://webservicesfiapjob.herokuapp.com/.

Como camada de segurança, utilizamos o spring-security usando como provider o próprio mongoDB. Tendo como base o schema USUARIOS, então, para acesso da maioria dos endpoints é necessário um Basic Auth utilizando as credenciais encriptadas via base64 (campos: email, senha). Para fins de testes e inicialização da aplicação é possível utilizar o usuário master 'admin', senha 'admin'.

Á partir disso, nossa API possibilita criar usuários, carros e inicialização de viagens com de carros autônomos. 

Em um fluxo teremos:
	
	- Usuário já cadastrado chama API de listagem de carros disponíveis. (/carros - getCarros);
	- A partir disso o usuário escolherá o carro e colocará seu destino, com isso a API poderá iniciar a viagem e ao mesmo tempo deixar o carro selecionado como indisponível. (/viagem - insert);
	- Com isso o cliente receberá um id da viagem e a partir dele, a qualquer momento ele poderá acioná-la para ter o status da mesma. (/viagem - getViagem);
	- O carro/cliente por sua vez sempre posicionará para a api sua posição, atualizando o documento viagem. (/viagem - update);
	- Á partir do momento que a viagem se encerra o dispositivo do cliente manda um update com status "CONCLUIDO", e com isso a viagem se encerra e o carro novamente passa a ficar disponível, terminando o ciclo. (/viagem - update);

Para documentação e melhor entendimento, a aplicação possui um swagger embarcado para que possa ser testado todos os passos acima e detalhes a mais. Para acesso basta se conectar via browser a URL "https://webservicesfiapjob.herokuapp.com/swagger-ui.html" e colocar no campo user e password o valor 'admin'.
