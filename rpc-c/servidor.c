#include <stdio.h>
#include "interface.h"

/* implementacao da funcao soma */
int * soma_1_svc (operandos *argp, struct svc_req *rqstp){
   static int result;

   printf ("Recebi chamado: soma %d %d\n", argp->a, argp->b);
   result = argp->a + argp->b;
   return (&result);
}

/* implementacao da funcao sub */
int * sub_1_svc (operandos *argp, struct svc_req *rqstp){
   static int result;

   printf ("Recebi chamado: sub %d %d\n", argp->a, argp->b);
   result = argp->a - argp->b;
   return (&result);
}