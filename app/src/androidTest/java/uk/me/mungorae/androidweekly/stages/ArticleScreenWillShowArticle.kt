package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.ArticleScreenActions
import uk.me.mungorae.androidweekly.api.Article

class ArticleScreenWillShowArticle(private val article: Article): Stage {

    override fun begin() {
        ArticleScreenActions.hasTitle(article.title)
        ArticleScreenActions.hasDescription(article.description)
    }
}