/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.apache.sysds.runtime.matrix.operators;

import org.apache.sysds.runtime.functionobjects.IndexFunction;

public class ReorgOperator extends Operator{
	private static final long serialVersionUID = -5322516429026298404L;

	public final IndexFunction fn;
	private final int k; //num threads
	
	public ReorgOperator(IndexFunction p) {
		//default degree of parallelism is 1 
		//(for example in MR/Spark because we parallelize over the number of blocks)
		this( p, 1 );
	}
		
	public ReorgOperator(IndexFunction p, int numThreads) {
		super(true);
		fn = p;
		k = numThreads;
	}

	public int getNumThreads() {
		return k;
	}

	public ReorgOperator setFn(IndexFunction fn) {
		return new ReorgOperator(fn, k);
	}
}
