/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.ui.interpreter.language;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

/**
 * This should be used as the result of a language interpreter's evaluation task.
 * <p>
 * The {@link #evaluationResult} Object will be displayed in the interpreter view's "result" viewer. It can be
 * <code>null</code> (nothing displayed in the result viewer), a single {@link Object} (displayed alone in the
 * result viewer) or a {@link Collection} of {@link Object}s (one line for each of them in the result viewer).
 * </p>
 * <p>
 * {@link #problems} can be populated with either a simple {@link org.eclipse.core.runtime.Status} or a
 * {@link org.eclipse.core.runtime.MultiStatus}. If this is not <code>null</code>, the issue(s) will be
 * reported on the interpreter UI.
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class EvaluationResult {
	/**
	 * This will hold the actual result of the evaluation. Note that this can legally be <code>null</code> if
	 * the evaluation either a) did result in a <code>null</code> result or b) the evaluation could not be run
	 * because of critical issues in either compilation or evaluation.
	 */
	private Object evaluationResult;

	/**
	 * This can hold any info, warning or error that has been encountered by the evaluation. This can legally
	 * be <code>null</code> if no problem was encountered.
	 */
	private IStatus problems;

	/**
	 * Creates an evaluation result given the evaluation issues. This assumes that critical errors were
	 * encountered during the evaluation or compilation, and that the evaluation itself could not be run.
	 * 
	 * @param problems
	 *            The problems encountered during the evaluation. Can be a
	 *            {@link org.eclipse.core.runtime.MultiStatus}.
	 */
	public EvaluationResult(IStatus problems) {
		this.problems = problems;
	}

	/**
	 * Creates an evaluation result given the actual result. This assumes that no issues were encountered
	 * during the evaluation.
	 * 
	 * @param evaluationResult
	 *            Result of the evaluation.
	 */
	public EvaluationResult(Object evaluationResult) {
		this.evaluationResult = evaluationResult;
	}

	/**
	 * Creates an evaluation result given the actual result and the problems encountered while avaluating the
	 * expression it.
	 * 
	 * @param evaluationResult
	 *            Result of the evaluation.
	 * @param problems
	 *            The problems encountered during the evaluation. Can be a
	 *            {@link org.eclipse.core.runtime.MultiStatus}.
	 */
	public EvaluationResult(Object evaluationResult, IStatus problems) {
		this.evaluationResult = evaluationResult;
		this.problems = problems;
	}

	/**
	 * Returns the evaluation result.
	 * 
	 * @return The evaluation result.
	 */
	public Object getEvaluationResult() {
		return evaluationResult;
	}

	/**
	 * Returns the problems encountered during this evaluation.
	 * 
	 * @return The problems encountered during this evaluation.
	 */
	public IStatus getProblems() {
		return problems;
	}

	/**
	 * Sets the actual evaluation result.
	 * 
	 * @param evaluationResult
	 *            The actual evaluation result.
	 */
	public void setEvaluationResult(Object evaluationResult) {
		this.evaluationResult = evaluationResult;
	}

	/**
	 * Sets the problems encountered during this evaluation to the given new status.
	 * 
	 * @param problems
	 *            The problems encountered during this evaluation.
	 */
	public void setProblems(IStatus problems) {
		this.problems = problems;
	}
}