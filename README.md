# kata2
#Bonnes pratiques et découpage en couche*

#http://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/

<pluginManagement>
			<plugins>
				<!-- This plugin's configuration is used to store Eclipse m2e settings 
					only. It has no influence on the Maven build itself. Remove when the m2e 
					plugin can correctly bind to Maven lifecycle -->
				<plugin>
					<groupId>org.eclipse.m2e</groupId>
					<artifactId>lifecycle-mapping</artifactId>
					<version>1.0.0</version>
					<configuration>
						<lifecycleMappingMetadata>
							<pluginExecutions>
								<pluginExecution>
									<pluginExecutionFilter>
										<groupId>org.jacoco</groupId>
										<artifactId>jacoco-maven-plugin</artifactId>
										<versionRange>[0.7.4,)</versionRange>
										<goals>
											<goal>prepare-agent</goal>
										</goals>
									</pluginExecutionFilter>
									<action>
										<ignore />
									</action>
								</pluginExecution>
								<pluginExecution>
									<pluginExecutionFilter>
										<groupId>com.github.trecloux</groupId>
										<artifactId>yeoman-maven-plugin</artifactId>
										<versionRange>[0.5,)</versionRange>
										<goals>
											<goal>build</goal>
										</goals>
									</pluginExecutionFilter>
									<action>
										<ignore />
									</action>
								</pluginExecution>								
								<pluginExecution>
									<pluginExecutionFilter>
										<groupId>com.github.kongchen</groupId>
										<artifactId>swagger-maven-plugin</artifactId>
										<versionRange>[3.1.0,)</versionRange>
										<goals>
											<goal>generate</goal>
										</goals>
									</pluginExecutionFilter>
									<action>
										<ignore />
									</action>
								</pluginExecution>
							</pluginExecutions>
						</lifecycleMappingMetadata>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
