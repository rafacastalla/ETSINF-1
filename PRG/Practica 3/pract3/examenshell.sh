#!/bin/bash
#---------------------  ESCRIPT ESQUEMA PARA EL EXAMEN  -------------------------------------

echo "${precios[@]}"

#-----------------------------------  CASE  ---------------------------------------

while [ $opcion != "q" ]; do
	menu;
	read -n 1 -p "Elige una de las opciones: " opcion
	case $opcion in
		"1")
			mostrarTodos $url;
			continuar
			;;
		"q")
			echo "Adios..."
			;;
		*)
			echo "Option not found."
			continuar
			echo "Remember that only choose one of this options."
			;;
	esac
done

# --------------------------------  IF, ELSE, ELIF --------------------------------

if [ $# == 3 ] ; then
	echo "todo va bien"
elif [ $# == 2 ] ; then
	echo "Introduce el nombre y los dos apellidos"
else
	echo "Si no ocurre ninguna de las anteriores."
fi

#------------------------------------------  FOR  --------------------------------------------

for (( i=0; i<3; i++ )) do
	i<${#precios[@]} ;    (( precios[i]=precios[j] )) 
done

#----------------------------------------  WHILE  ------------------------------------------------

while [ $incremento -lt $ahorros ] ; do
	(( i++ )) 
done

while read precio ; do
	precios[$i]=$precio
	(( i++ ))
done < sedprueba.txt

#-----------------------------------------  READ -----------------------------------------------

read -s pasword -p "texto" -n 1 caracteres

read -r col1 col2 col3 <<< "$var"

IFS=":|@" read -r col1 col2 col3 col4 <<< "hello:world|in@bash"

printf "col1: %s col2: %s col3 %s col4 %s\n" "$col1" "$col2" "$col3" "$col4"

#-------------------------------------  a  -------------------------------------------










