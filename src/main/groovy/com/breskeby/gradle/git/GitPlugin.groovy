package com.breskeby.gradle.git

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.lib.RepositoryBuilder

class GitPlugin implements Plugin<Project> {
    public static final String GIT_PLUGIN_NAME = 'git'

	public void apply(final Project project) {
		def builder = new RepositoryBuilder();
        println(project.rootDir)
        Repository repository = builder.setGitDir(new File(project.rootDir, ".git"))
                                       .readEnvironment()
                                       .findGitDir()
                                       .build()
        def logTask = project.tasks.add("printGitLog", CommitLogTask)
        logTask.repository = repository
		//add your implementation here
    }
}
