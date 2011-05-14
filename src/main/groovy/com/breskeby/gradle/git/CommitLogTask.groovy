package com.breskeby.gradle.git

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.LogCommand
import org.eclipse.jgit.lib.ObjectId

/**
 * @Author: Rene
 * Email: rene@breskeby.com
 */
class CommitLogTask extends DefaultTask{

    Repository repository

    @TaskAction void printCommitLog(){
        Git git = new Git(repository)
        LogCommand gitlog = git.log();
        gitlog = gitlog.addRange(repository.resolve("HEAD^^^^"),
                                 repository.resolve("HEAD^^"));

        gitlog.call().each{ commit ->
            println "${commit.getName()} -- ${commit.getCommitTime()} -- ${commit.getCommitterIdent().getName()}"
        }
    }
}
