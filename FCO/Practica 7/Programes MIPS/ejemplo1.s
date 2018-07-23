.text 0x00400000 # Dirección inicio código
.globl __start # Etiqueta global
__start:
addi $8, $0, 1 # Inicializa $8 con 1
addi $9, $0, -2 # Inicializa $9 con -2
add $10, $8, $9 # $10 <- $8 + $9
.end # Final del programa