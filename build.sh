# Tasks:
	# Check input syntax correctness 
	# gcc -fsyntax-only $1 
	# #include removal
	python Preprocessor/preprocess.py <$1 >tmp/preproc.c
	# Macro expansion
	gcc -E tmp/preproc.c -o tmp/macroexp.c
	cd Layer0 && echo "Executing Layer0" && java CParser < ../tmp/macroexp.c > ../tmp/temp0.c 
	cd ..
	cd Layer1 && echo "Executing Layer1" && java ParserMain <../tmp/temp0.c >../tmp/temp1.c
	cd ..
	cd Layer2 && echo "Executing Layer2" && java ParserMain <../tmp/temp1.c 	>../tmp/temp2.c
	cd ..
	cd Layer3 && echo "Executing Layer3" && java ParserMain <../tmp/temp2.c 	>../tmp/temp3.c
	cd ..
	# echo "Assuming max 4 layer recursive block depth"
	# cd Layer4 && echo "Executing Layer4" && java ParserMain <../tmp/temp3.c 	>../tmp/temp4.c
	cd Layer4 && echo "Executing Layer4" && python recurse.py

	# java ParserMain <../tmp/temp4.c 	>../tmp/temp5.c
	# java ParserMain <../tmp/temp5.c 	>../tmp/temp6.c
	# java ParserMain <../tmp/temp6.c 	>../tmp/temp7.c
	cd ../Layer6 && echo "Executing Layer6" && java ParserMain < ../tmp/temp4.c > ../tmp/temp5.c
	cd ../tmp && cat deps temp5.c >output.c
