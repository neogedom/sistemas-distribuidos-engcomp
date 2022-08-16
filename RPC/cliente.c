#include <stdio.h>
#include "interface.h"

/* funcao que invoca a RPC soma_1 */
int soma (CLIENT *clnt, int a, int b){
   operandos ops;
   int *resultado;
	ops.a = a;
   ops.b = b;
   /* chama a funcao remota */
   resultado = soma_1 (&ops,clnt);

   if (resultado == NULL){
     printf ("Problemas ao chamar a funcao remota\n");
     exit (1);
   }
   return (*resultado);
}

/* funcao que invoca a RPC sub_1 */
int sub (CLIENT *clnt, int x, int y){
   operandos ops;
   int *resultado;
   ops.a = x;
   ops.b = y;
   /* chama a funcao remota */
   resultado = sub_1 (&ops,clnt);

   if (resultado == NULL){
      printf ("Problemas ao chamar a funcao remota\n");
      exit (1);
   }
   return (*resultado);
}

int main( int argc, char *argv[]){
   CLIENT *clnt;
   int x,y;
   /* verifica se o cliente foi chamado corretamente */
   if (argc!=4){
      fprintf (stderr,"Sintaxe: %s hostname operando1 operando2\n",argv[0]);
      exit (1);
   }
   /* cria uma struct CLIENT que referencia uma interface RPC */
   clnt = clnt_create (argv[1], SOMASUB_PROG, SOMASUB_VERSION, "udp");
   /* verifica se a referencia foi criada */
   if (clnt == (CLIENT *) NULL){
      clnt_pcreateerror (argv[1]);
      exit(1);
   }
   /* converte os argumentos de linha de comando para inteiro*/
   x = atoi (argv[2]);
   y = atoi (argv[3]);
   /* executa os procedimentos remotos */
   printf ("%d + %d = %d\n", x, y, soma (clnt,x,y));
   printf ("%d - %d = %d\n", x, y, sub (clnt,x,y));
   return (0);
}