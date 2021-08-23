VERSION=1.17.1
OUT_BLOCKS=../docs/data/blocks.json
JAR_FILE=./$(VERSION).jar

MUNCH=python burger/munch.py
MUNCH_ARGS=--download $(VERSION) --toppings blocks --output $(OUT_BLOCKS)

IN_TEXTURES=assets/minecraft/textures/block
OUT_TEXTURES=../docs/textures/block

JAR=jar
JAR_ARGS=-xf $(JAR_FILE) $(IN_TEXTURES)

init:
	pip install -U pip
	pip install -r requirements.txt

jar: init
	$(MUNCH) --download $(VERSION) --toppings None 1>/dev/null

blocks: init
	$(MUNCH) $(MUNCH_ARGS)

textures: jar
	$(JAR) $(JAR_ARGS)
	rm -r $(OUT_TEXTURES) || true
	mkdir -p $(shell dirname $(OUT_TEXTURES))
	mv $(IN_TEXTURES) $(OUT_TEXTURES)
	rm -r $(shell echo $(IN_TEXTURES) | awk -F/ '{print $$1}')

clean:
	rm $(JAR_FILE)

.PHONY: init blocks textures clean
