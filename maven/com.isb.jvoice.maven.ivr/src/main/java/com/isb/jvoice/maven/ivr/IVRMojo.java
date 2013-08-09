package com.isb.jvoice.maven.ivr;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.HashSet;
import java.util.Set;


import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import com.isb.jvoice.maven.call.CallMojo;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal IVRBuilding
 * 
 * @phase build-ivr-sources
 */
public class IVRMojo extends CallMojo{


	/**
	 * A set of patterns matching files from the sourceDirectory that should be processed as grammars.
	 * 
	 * @parameter
	 */
	protected Set<String> includes = new HashSet<>();

	/**
	 * A set of exclude patterns.
	 * 
	 * @parameter
	 */
	protected Set<String> excludes = new HashSet<>();

	/**
	 * The Maven Project Object
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject project;


	@Override
	public void execute() throws MojoExecutionException {

	}


}
