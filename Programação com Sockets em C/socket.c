#include <stdio.h>
#include<winsock2.h>

// Para programar sockets no windows precisamos da winsock.dll
// Há duas versões da winsock. A versão 1.1 (windows 95 para baixo) e a versão 2.0 (windows 98 para cima)
// Isso acarreta um pouco mais de código


int main (int argc, char *argv[]) {

   int socket_desc, conexao, c; 
   struct sockaddr_in servidor, cliente;
   

   WSADATA dados; // variável usada para iniciar a dll (Exclusivo para Windows)

    // WSAStartup - função que verifica a versão da dll e inicia
    // MAKEWORD(2,0) - é a versão da 2.0 da dll
   if(WSAStartup(MAKEWORD(2, 0), &dados == SOCKET_ERROR)) {
       
//*****************************************************************
       // Criando um socket
       // argumentos: dominio, tipo, protocolo
       socket_desc = socket(AF_INET, SOCK_STREAM, 0);
       if (socket_desc == -1) {
           printf("Não foi possivel criar o socket\n");
           return -1;
       }
       
       // Preparando a struct do socket do servidor
       servidor.sin_family = AF_INET; // Domínio, para conexão entre computadores usar AF_INET
       servidor.sin_port = htons(1234); // A porta da conexão. htons para lidar com as diferenças na posição dos bytes
       servidor.sin_addr.s_addr = INADDR_ANY; // O endereço da conexão. INADDR_ANY para pegar o IP do S.O

      
        //Associando o socket à porta e ao endereço
        // Argumentos: o socket, a estrutura que representa o servidor, o tamanho do servidor
        // Em caso de erro, bind retornará -1
        if (bind(socket_desc, (struct sockaddr *) &servidor, sizeof(servidor)) < 0) {
            print("Erro ao fazer bind\n");
        }

        puts("Bind efetuado com sucesso\n");
    
        //Aceitando e tratando conexões
        puts("Aguardando por conexoes");
        c = sizeof(struct sockaddr_in);
        conexao = accept(socket_desc, (struct sockaddr *) &cliente, sizeof(cliente));
       //Checagem de erro. Se a conexão falhar falhar, ele retornará -1
        if (conexao < 0) {
            printf("Erro ao realizar a conexao\n");
            exit(1);
        }
        

       closesocket(socket_desc); //destruindo a conexão do socket_desc
       
       
   }

   WSACleanup(); //limpa a estrutura WSA
    return 0;

}