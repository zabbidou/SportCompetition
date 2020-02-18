.PHONY: build run

build: 
	javac -sourcepath src -d build src/tema3/*.java

run: build
	java -cp .:build:tema3/*.class tema3.Main $(COMANDA) $(IN1) $(IN2) $(OUT)

clean:
	rm ./build/tema3/*.class
