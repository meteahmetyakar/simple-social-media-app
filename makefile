make: 1 2 3

1:
	cd $(CURDIR)/SocialMedia; \
	javac *.java; \
	cd ..; \
	java SocialMedia.Scenario1
# .PHONY: all
2:
	cd $(CURDIR)/SocialMedia; \
	javac *.java; \
	cd ..; \
	java SocialMedia.Scenario2
# .PHONY: all
3:
	cd $(CURDIR)/SocialMedia; \
	javac *.java; \
	cd ..; \
	java SocialMedia.Scenario3
# .PHONY: all
all:
	cd $(CURDIR)/SocialMedia; \
	javac *.java; \
	cd ..; \
	java SocialMedia.Scenario3
# .PHONY: all

# all: dummy
#     CURRENT_DIR=$$(pwd) && cd $(CURDIR)/SocialMedia && javac *.java && cd $$CURRENT_DIR && java SocialMedia.TestClass1
