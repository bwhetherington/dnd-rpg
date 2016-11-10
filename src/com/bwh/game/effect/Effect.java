package com.bwh.game.effect;

/**
 * The base type of all effects. An effect must both determine whether or not
 * it can execute, and have a method to be run when it is executed.
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public interface Effect {
	
	/**
	 * Determines whether or not the effect can be executed.
	 * @return whether or not the effect can be executed
	 */
    boolean canExecute();
    
    /**
     * Executes the effect.
     */
    void execute();
}
