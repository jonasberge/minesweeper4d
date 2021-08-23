VERSION=1.17.1
OUT_BLOCKS=../public/data/blocks.json
CLEAN_FILES=./*.jar

MUNCH=python burger/munch.py
MUNCH_ARGS=--download $(VERSION) --toppings blocks --output $(OUT_BLOCKS)

init:
	pip install -U pip
	pip install -r requirements.txt

blocks: init
	$(MUNCH) $(MUNCH_ARGS)

clean:
	rm $(CLEAN_FILES)

.PHONY: init blocks clean
