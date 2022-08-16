#define PROGRAM_NUMBER 0x20001234
#define VERSION_NUMBER 1

/*estutura com os parametros*/
struct operandos{
  int a;
  int b;
};


/*interface com os procedimentos ofertados pelo servidor*/
program SOMASUB_PROG{
  version SOMASUB_VERSION{
     int SOMA (operandos) = 1;
     int SUB (operandos) = 2;
   } = VERSION_NUMBER;
} = PROGRAM_NUMBER;