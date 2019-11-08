### Branches:

* master: intial boilerplate code and added some configuration
* user-persistence: Database added 
* inputValidation: User registration input gets validated
* introducingVault: Securing secret application data; 
 	* Create vault.conf file in the directory where you unzip vault download and enter configuration in the file
 	* Vault command: `./vault server -config vault.conf`
	* Set env variable on the new terminal: `export VAULT_ADDR=http://localhost:8200`
	* Initialize vault: `./vault operator init`
	* Check status: `./vault status`
	* Unseal: `./vault operator unseal <unseal key>` (do this three time with different keys)
	* Set environment variable for vault token: `export VAULT_TOKEN=<Initial Root Token>`
	* Enable write to vault: `./vault secrets enable -path=secret kv`
	* Start writing: `./vault write secret/<your application name> <key>=<value>`. Eg. `vault write secret/myApp pass_key=password`
	* To use in your application:
  		* add vault dependency - spring-cloud-vault-dependencies and spring-cloud-starter-vault-config
  		* create bootstrap.yml file and add vault config. (host: localhost, port: 8200, scheme: http, authentication: TOKEN, token: <Inital Root Token>) (		it won't work with application.properties and application name needs to be specified in this bootstrap.yml file)
  		* find a way not to put the master token on bootstrap.yml file. One way to do that is pass it as a command line argument during start up
  	* To write multiple key value pair: 
  		* Write key value pairs in json file: `{"<key1>": "<value1>", "<key2>": "<value2>" ... }`
  		* Execute the command: `./vault write secret/<app name> @<file name>`. Eg. `./vault write secret/my-app @secret.json`
* additionalLayersOfSecurity
	* import mail dependency
	* configure mail server 
	* user event handlers 