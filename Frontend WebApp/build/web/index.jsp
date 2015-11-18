<!-- Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web
Membuat website tanya jawab seperti Stack Exchange dengan REST dan SOAP dan arsitektur berorientasi servis.
Author: 
- Irene Wiliudarsan (13513002)
- Angela Lynn       (13513002)
- Devina Ekawati    (13513002) -->
<!-- File: index.jsp -->

<!DOCTYPE html>
<html>
  <head>
    <title>Home</title>
    <meta charset="utf-8"/>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
  </head>
  <body>
    <!-- Title -->
    <div class="title">
      <a href="index.html">
        Simple StackExchange
      </a>
    </div>

    <div class="content">
      <!-- Search Bar -->
      <div class="stacked" id="search-section">
        <form id="search-form" name="search-form" action="" method="post" onsubmit="return searchFormValidation()">
          <input id="search-key" name="search-key" type="text">
          <input class="button" name="search-submit" type="submit" value="Search">
        </form>
        <br>
        Cannot find what you are looking for? 
        <a class="yellow" href="ask-question.html">
          Ask here
        </a>
      </div>

      <!-- Recently Asked Questions -->
      <div class="stacked">
        <div class="subtitle">
          Recently Asked Questions
        </div>
        <div class="questions-list">
          <div class="same-height-row border-bottom">
            <div class="vote-number">
              3
              <br>
              Votes
            </div>
            <div class="answer-number">
              1
              <br>
              Answers
            </div>
            <div class="right-position">
              <div class="answer-question-detail">
                <!-- Question Topic & Content -->
                <a href="question-detail.html">
                  <div class="question-topic">
                    Question Topic
                  </div>
                  <div class="question-content">
                    Question content here. Question content here. Question content here. Question content here. Question content here. Question content here. Question content here. Question content here.
                  </div>
                </a>
              </div>
              asked by
              <span class="blue">
                Jen Hammington
              </span>
              |
              <a class="yellow" href="ask-question.html">
                edit
              </a>
              |
              <a class="red" href="index.html" onclick="return confirm('Do you want to delete this post?')">
                delete
              </a>
            </div>
          </div>
          <!-- If no questions: Sorry, no questions found. -->
        </div>
      </div>
    </div>

    <!-- JavaScript -->
    <script src="js/script.js"></script>
  </body>
</html>