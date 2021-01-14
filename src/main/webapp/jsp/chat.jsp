<%@include file="../lib(header&footer)/mainHead.jsp"%>

    <div class="box d-flex justify-content-around p-5">
        <div class="chess mx-auto">
            <img class="mx-auto" style="width: 80%;" src="https://betacssjs.chesscomfiles.com/bundles/web/images/offline-play/standardboard.png" alt="">

        </div>

        <div class="chat ">
            <div class="container-fluid h-100">
                <div class="row justify-content-center h-100">
                    <!--col-md-8 col-xl-6-->
                    <div class=" chat">
                        <div class="card">
                            <!--chat header-->
                            <div class="card-header msg_head">

                                <div class="d-flex bd-highlight">

                                    <div class="img_cont">
                                        <img src="https://i.pinimg.com/originals/1d/f2/e1/1df2e14bf3c45c0cd6582a4a2b9b0bb6.jpg" class="rounded-circle user_img">
                                    </div>

                                    <div class="user_info">
                                        <span>Server Player</span>
                                    </div>

                                </div>

                            </div>
                            <!--chat dialogue-->
                            <div class="card-body msg_card_body">

                                <!--server dialogue-->
                                <div class="d-flex justify-content-start mb-4 mr-5">
                                    <div class="msg_cotainer">
                                        i love pony
                                        <span class="msg_time">8:40 AM, Today</span>
                                    </div>
                                </div>
                                <!--ur dialogue-->
                                <div class="d-flex justify-content-end mb-4 ml-5">
                                    <div class="msg_cotainer_send">
                                        i don't XD :D
                                        <span class="msg_time_send">${time}</span>
                                    </div>
                                </div>

                            </div>

                            <!--enter message to chat !CHAT FOOTER-->
                            <div class="card-footer">
                                <form action="${pageContext.request.contextPath}/chat" method="post" class="input-group" enctype="multipart/form-data">
                                    <!--visual file btn-->
                                    <div id="fileInput" onclick="btn(this.id)" class="input-group-append">
                                        <span class="input-group-text attach_btn">
                                            <i  class="fas fa-paperclip"></i>
                                        </span>
                                    </div>

                                    <textarea name="textInput" class="form-control type_msg" placeholder="Type your message..."></textarea>

                                    <!--visual submit btn-->
                                    <div id="send" onclick="btn(this.id)" class="input-group-append">
                                        <span class="input-group-text send_btn"><i class="fas fa-location-arrow"></i></span>
                                    </div>

                                    <!--real hidden btn-->
                                    <div hidden>
                                        <input type="file" id="fileInputBtn" name="file">
                                        <input type="submit" id="sendBtn">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>

</html>