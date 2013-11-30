
.... will need to do: 
add to standalone.xml :

 		<security-domain name="mongo_auth" cache-type="default">
                    <authentication>
                        <login-module code="com.redhat.mailinglistOnline.security.MongoDbLoginModule" flag="required">
                            <module-option name="hashAlgorithm" value="SHA-256"/>
                        </login-module>
                    </authentication>
                </security-domain>
