
<%@page import="com.moonshotteam.urlshortener.model.HomeData"%>
<%@page import="com.moonshotteam.urlshortener.HomeRequestManager"%>
<%
    HomeData data = new HomeRequestManager().getHomeData(request);
%>

<html lang="en">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=5.0">
    <title>Moonshotteam Url Shortener</title>
    <meta name="description" content="TinyURL.com is the original URL shortener that shortens your unwieldly links into more manageable and useable URLs.">
    <meta name="keywords" content="tinyurl url save share shorten analyze">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
    <link rel="stylesheet" href="css/front.css?id=23317bfcf45e05c358b93cbe20a9cc4c">
    <!-- Favicons -->
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-16.png"
      sizes="16x16">
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-32.png"
      sizes="32x32">
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-48.png"
      sizes="48x48">
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-64.png"
      sizes="64x64">
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-128.png"
      sizes="128x128">
    <link rel="apple-touch-icon" sizes="152x152" href="https://tinyurl.com/images/icons/favicon-152.png">
    <link rel="apple-touch-icon" sizes="167x167" href="https://tinyurl.com/images/icons/favicon-167.png">
    <link rel="apple-touch-icon" sizes="180x180" href="https://tinyurl.com/images/icons/favicon-180.png">
    <link rel="icon" type="image/png" href="https://tinyurl.com/images/icons/favicon-192.png"
      sizes="192x192">

    <style type="text/css">.resize-observer[data-v-8859cc6c]{position:absolute;top:0;left:0;z-index:-1;width:100%;height:100%;border:none;background-color:transparent;pointer-events:none;display:block;overflow:hidden;opacity:0}.resize-observer[data-v-8859cc6c] object{display:block;position:absolute;top:0;left:0;height:100%;width:100%;overflow:hidden;pointer-events:none;z-index:-1}</style>
    <style type="text/css">
.vue-modal-top,
.vue-modal-bottom,
.vue-modal-left,
.vue-modal-right,
.vue-modal-topRight,
.vue-modal-topLeft,
.vue-modal-bottomLeft,
.vue-modal-bottomRight {
  display: block;
  overflow: hidden;
  position: absolute;
  background: transparent;
  z-index: 9999999;
}
.vue-modal-topRight,
.vue-modal-topLeft,
.vue-modal-bottomLeft,
.vue-modal-bottomRight {
  width: 12px;
  height: 12px;
}
.vue-modal-top {
  right: 12;
  top: 0;
  width: 100%;
  height: 12px;
  cursor: n-resize;
}
.vue-modal-bottom {
  left: 0;
  bottom: 0;
  width: 100%;
  height: 12px;
  cursor: s-resize;
}
.vue-modal-left {
  left: 0;
  top: 0;
  width: 12px;
  height: 100%;
  cursor: w-resize;
}
.vue-modal-right {
  right: 0;
  top: 0;
  width: 12px;
  height: 100%;
  cursor: e-resize;
}
.vue-modal-topRight {
  right: 0;
  top: 0;
  background: transparent;
  cursor: ne-resize;
}
.vue-modal-topLeft {
  left: 0;
  top: 0;
  cursor: nw-resize;
}
.vue-modal-bottomLeft {
  left: 0;
  bottom: 0;
  cursor: sw-resize;
}
.vue-modal-bottomRight {
  right: 0;
  bottom: 0;
  cursor: se-resize;
}
#vue-modal-triangle::after {
  display: block;
  position: absolute;
  content: '';
  background: transparent;
  left: 0;
  top: 0;
  width: 0;
  height: 0;
  border-bottom: 10px solid #ddd;
  border-left: 10px solid transparent;
}
#vue-modal-triangle.clicked::after {
  border-bottom: 10px solid #369be9;
}
</style><style type="text/css">
.vm--block-scroll {
  overflow: hidden;
  width: 100vw;
}
.vm--container {
  position: fixed;
  box-sizing: border-box;
  left: 0;
  top: 0;
  width: 100%;
  height: 100vh;
  z-index: 999;
}
.vm--overlay {
  position: fixed;
  box-sizing: border-box;
  left: 0;
  top: 0;
  width: 100%;
  height: 100vh;
  background: rgba(0, 0, 0, 0.2);
  /* z-index: 999; */
  opacity: 1;
}
.vm--container.scrollable {
  height: 100%;
  min-height: 100vh;
  overflow-y: auto;
  -webkit-overflow-scrolling: touch;
}
.vm--modal {
  position: relative;
  overflow: hidden;
  box-sizing: border-box;

  background-color: white;
  border-radius: 3px;
  box-shadow: 0 20px 60px -2px rgba(27, 33, 58, 0.4);
}
.vm--container.scrollable .vm--modal {
  margin-bottom: 2px;
}
.vm--top-right-slot {
  display: block;
  position: absolute;
  right: 0;
  top: 0;
}
.vm-transition--overlay-enter-active,
.vm-transition--overlay-leave-active {
  transition: all 50ms;
}
.vm-transition--overlay-enter,
.vm-transition--overlay-leave-active {
  opacity: 0;
}
.vm-transition--modal-enter-active,
.vm-transition--modal-leave-active {
  transition: all 400ms;
}
.vm-transition--modal-enter,
.vm-transition--modal-leave-active {
  opacity: 0;
  transform: translateY(-20px);
}
.vm-transition--default-enter-active,
.vm-transition--default-leave-active {
  transition: all 2ms;
}
.vm-transition--default-enter,
.vm-transition--default-leave-active {
  opacity: 0;
}
</style><style type="text/css">
.vue-dialog {
  font-size: 14px;
}
.vue-dialog div {
  box-sizing: border-box;
}
.vue-dialog-content {
  flex: 1 0 auto;
  width: 100%;
  padding: 14px;
}
.vue-dialog-content-title {
  font-weight: 600;
  padding-bottom: 14px;
}
.vue-dialog-buttons {
  display: flex;
  flex: 0 1 auto;
  width: 100%;
  border-top: 1px solid #eee;
}
.vue-dialog-buttons-none {
  width: 100%;
  padding-bottom: 14px;
}
.vue-dialog-button {
  font-size: inherit;
  background: transparent;
  padding: 0;
  margin: 0;
  border: 0;
  cursor: pointer;
  box-sizing: border-box;
  line-height: 40px;
  height: 40px;
  color: inherit;
  font: inherit;
  outline: none;
}
.vue-dialog-button:hover {
  background: #f9f9f9;
}
.vue-dialog-button:active {
  background: #f3f3f3;
}
.vue-dialog-button:not(:first-of-type) {
  border-left: 1px solid #eee;
}
</style><style type="text/css">.vue-notification-group{display:block;position:fixed;z-index:5000}.vue-notification-wrapper{display:block;overflow:hidden;width:100%;margin:0;padding:0}.notification-title{font-weight:600}.vue-notification-template{background:#fff}.vue-notification,.vue-notification-template{display:block;box-sizing:border-box;text-align:left}.vue-notification{font-size:12px;padding:10px;margin:0 5px 5px;color:#fff;background:#44a4fc;border-left:5px solid #187fe7}.vue-notification.warn{background:#ffb648;border-left-color:#f48a06}.vue-notification.error{background:#e54d42;border-left-color:#b82e24}.vue-notification.success{background:#68cd86;border-left-color:#42a85f}.vn-fade-enter-active,.vn-fade-leave-active,.vn-fade-move{transition:all .5s}.vn-fade-enter,.vn-fade-leave-to{opacity:0}</style>
    <style>.closePopOver[data-v-53cd4afd]{padding:9px 12px}</style>
    <style>.navigation-link.active[data-v-d8811b88],.navigation-link.router-link-active[data-v-d8811b88]{background-color:#002342}.navigation-link[data-v-d8811b88]:hover{background-color:#10bde5;text-decoration:none}.navigation-link[data-v-d8811b88]{color:#fff;display:inline-block;font-size:15px;font-weight:500;padding:10px 14px;text-align:center}.navigation-link.disabled[data-v-d8811b88]{color:hsla(0,0%,100%,.75)}.z-15[data-v-d8811b88]{z-index:15}.account-img-inline[data-v-d8811b88]{border-radius:20px;margin-bottom:-8px;margin-left:10px;margin-top:-10px;max-height:36px;max-width:36px}.btn-create[data-v-d8811b88]{font-family:Bungee,cursive;font-size:16px!important;letter-spacing:.1em;padding:8px 14px}.nav-link-m[data-v-d8811b88],.nav-link-m-noactive[data-v-d8811b88]{display:block;font-weight:700!important}.nav-link-m.router-link-exact-active[data-v-d8811b88]{background-color:#f8f9fa;border-right:5px solid #28c98b}.nav-link-m-noactive[data-v-d8811b88]:hover,.nav-link-m[data-v-d8811b88]:hover{background-color:#f8f9fa}.nav-menu[data-v-d8811b88]{background:#fff;border-radius:10px;font-size:.9em;left:0;list-style-type:none;padding:15px 0;position:absolute;top:55px;width:100%}</style>
    <style>a[data-v-f246f6fe]{color:hsla(0,0%,100%,.5)}</style>
    <style>.a[data-v-2895f6bc]{fill:#1c3068}.b[data-v-2895f6bc]{fill:#91b33e;fill-rule:evenodd}</style>
    <style>.share-network[data-v-441f4638]{cursor:pointer}.share-network[data-v-441f4638]:hover{color:#087da8!important}</style>
    <style>input.form-control[readonly][data-v-2eb0498e]{background-color:transparent}input.form-control[data-v-2eb0498e]:focus{border:1px solid #e5e5e5;box-shadow:none}</style>

    <meta id="bbafmabaelnnkondpfpjmdklbmfnbmol">
  </head>
  <body>
    <div id="tinyurl">
      <div class="root"><a href="#main-content" class="skip-link">Skip to
          Content</a>
        <div data-v-d8811b88="">
          <div data-v-d8811b88="" role="alert" class="sr-only"> By using this
            site, you agree to our Terms of Use, which include a mandatory
            arbitration provision. Click the link in the footer to read the
            terms.
          </div>
          <header data-v-d8811b88="" class="pl-3 pl-lg-5 pr-3 pr-md-5 py-3">
            <nav data-v-d8811b88="" role="navigation" class="d-flex">
              <h1 data-v-d8811b88="" class="header__logo d-flex font-weight-normal"><a
                  data-v-d8811b88=""
                  href="/app/"
                  aria-current="page"
                  class="router-link-exact-active router-link-active">TinyURL</a></h1>
              <div data-v-d8811b88="" class="flex-grow-1">
                <div data-v-d8811b88="" class="d-none d-md-flex flex-wrap justify-content-end align-items-center"><br>
                  <div data-v-d8811b88="" role="menu" class="z-15">
                    <div data-v-d8811b88="" class="dropdown"></div>
                  </div>
                </div>
                <div data-v-d8811b88="" class="text-right d-flex d-md-none flex-wrap justify-content-end"><!---->
                  <button data-v-d8811b88="" type="button" aria-label="Menu" class="btn btn-outline-light"></button></div>
              </div>
            </nav>
            <!----></header>
        </div>
        <div id="main-content"></div>
        <div class="d-flex flex-column overflow-y-a h-100">
          <section class="text-white h-100">
            <div class="container-fluid h-100">
              <div class="row align-items-center h-100">
                <div class="col-12 col-md-7 col-lg-5 col-xl-4 my-3 my-lg-0 mb-3">
                  <div class="heroHome-2__left create-form">
                    <div class="card rounded-10 bg-g-1 text-dark mb-0">
                      <div class="card-body p-2 p-sm-3">
                        <div data-v-2eb0498e="" role="dialog"><!---->
                            <!-- FORM START --->


                          <form method="post" name="main_form">
                            <div data-v-2eb0498e="" class="form-group mb-3"><label
                                data-v-2eb0498e=""
                                for="long-url"
                                class="label-fancy mb-1"><svg
                                  data-v-2895f6bc=""
                                  data-v-2eb0498e=""
                                  xmlns="http://www.w3.org/2000/svg"
                                  viewBox="0 0 32 32"
                                  width="24"
                                  height="24"
                                  class="mr-2"><path
                                    data-v-2895f6bc=""
                                    d="M10.27,6.64l2.88-2.88A10,10,0,0,1,24.59,1.35a11.54,11.54,0,0,1,6.05,6.06,10,10,0,0,1-2.4,11.44l-2.88,2.89.07-6.15A5.88,5.88,0,0,0,26.71,9.1,7.48,7.48,0,0,0,22.9,5.29a5.86,5.86,0,0,0-6.48,1.28ZM3.76,13.15,6.3,10.6A3.76,3.76,0,0,0,7.38,13l1.31,1.3-1.9,1.9a5.91,5.91,0,0,0-1.5,6.71A7.48,7.48,0,0,0,9.1,26.71a5.91,5.91,0,0,0,6.71-1.5l1.91-1.91L19,24.61a3.53,3.53,0,0,0,1,.7h0a3.92,3.92,0,0,0,1.16.35l.24,0-2.55,2.55A10,10,0,0,1,7.41,30.65a11.54,11.54,0,0,1-6-6.06A10,10,0,0,1,3.76,13.15Z"
                                    class="a"></path>
                                  <path data-v-2895f6bc="" d="M17,19.21l-3.84,3.9c-2.5,2.54-6.7-1.89-4.27-4.35l3.83-3.9L9.22,11.3a1.07,1.07,0,0,1,0-1.5,1,1,0,0,1,.67-.31l11.35-.12a1,1,0,0,1,1.17,1.21l-.13,11.58a1,1,0,0,1-1.17.91,1.09,1.09,0,0,1-.6-.31Z"
                                    class="b"></path></svg>
                                Enter a long URL to make a TinyURL
                              </label> <input name="long-url" id="long-url"
                                value="<%= data.getOriginalUrl()!=null?data.getOriginalUrl():"" %>"
                                aria-label="Long URL"
                                required="required"
                                class="enterurl form-control form-control-lg form-control-fancy text-t-green"
                                type="text">
                              <!---->
                              <!----></div>

                              <% if (data.getError()!=null) { %>
                              <h3 style="color:red"><%= data.getError() %></h3>
                              <% } %>
                                
                                <!-- START RESULT URL -->
                                 <% if (data.getShortUrl()!=null) { %>
                                 <div>
                                     <div data-v-2eb0498e="" class="form-group mb-3">
                                         <label data-v-2eb0498e="" class="label-fancy">TinyURL</label> 
                                         <div data-v-2eb0498e="" class="mt-n2">
                                             <input value="<%=data.getShortUrl()%>" data-v-2eb0498e="" readonly="readonly" class="form-control form-control-lg form-control-fancy mt-2 text-break text-t-green"> 
                                        </div>
                                     </div>
                                 </div>
                                 <% } %>
                                <!-- END RESULT URL -->

                            <div data-v-2eb0498e="" class="d-flex align-items-center mt-3">
                              <button
                                  type="submit"
                                data-v-2eb0498e=""
                                class="btn-make-url btn btn-block btn-t-green btn-xl d-none d-md-block">Make
                                TinyURL!</button> 
                              <button data-v-2eb0498e="" type="submit" class="btn-make-url btn btn-block btn-t-green btn-xl d-md-none">Make
                                TinyURL!</button>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                    <!----></div>
                </div>
                <div class="col-12 col-md-5 col-lg-4 col-xl-3 order-3 order-md-2 my-3 my-lg-0 d-none d-md-block mb-3">
                  <div class="heroHome-2__cont font-weight-bold"> Welcome to
                    <h2 class="logoInText pb-2">TinyURL</h2>
                    <p>Create a free account to enjoy:</p>
                    <ul>
                      <li>Easy Link Shortening</li>
                      <li>Full Link History</li>
                      <li>Customized TinyURLs</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
        <div class="background-img"><svg width="510" height="227" viewBox="0 0 510 227"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
            class="background-img-top"><path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M-87.152 -39.8215C-88.9236 -97.5924 -78.1971 -154.94 -48.4234 -204.479C-20.7542 -250.517 24.1466 -281.369 72.3104 -305.144C118.507 -327.949 168.356 -332.792 219.715 -336.844C285.535 -342.038 369.083 -381.424 412.88 -332.018C457.935 -281.194 406.048 -201.31 399.82 -133.678C395.679 -88.7194 394.135 -46.317 382.55 -2.68C368.135 51.6174 373.1 123.327 324.232 151.04C275.433 178.714 218.732 122.276 162.632 122.037C93.5849 121.742 20.3777 187.044 -37.5683 149.496C-93.687 113.131 -85.1022 27.0177 -87.152 -39.8215Z"
              fill="url(#paint0_linear)"
              fill-opacity="0.4"></path>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M-188.911 -99.6179C-180.859 -164.877 -158.829 -227.486 -116.742 -278.006C-77.6303 -324.955 -21.7855 -351.835 36.4978 -370.192C92.4006 -387.799 149.286 -384.577 207.733 -380.204C282.636 -374.6 383.414 -404.355 424.066 -341.195C465.884 -276.222 393.661 -195.431 374.9 -120.476C362.428 -70.6498 353.32 -23.2462 332.709 23.8C307.062 82.3393 300.177 163.824 240.418 186.486C180.743 209.115 126.807 135.805 63.777 125.782C-13.8004 113.447 -107.459 174.137 -166.079 121.848C-222.85 71.2077 -198.227 -24.1155 -188.911 -99.6179Z"
              fill="url(#paint1_linear)"
              fill-opacity="0.3"></path>
            <defs><linearGradient id="paint0_linear" x1="403.713" y1="80.0373" x2="-60.6291"
                y2="-29.7743"
                gradientUnits="userSpaceOnUse"><stop
                  stop-color="#9EE6F7"
                  stop-opacity="0"></stop>
                <stop offset="1" stop-color="#9EE6F7" stop-opacity="0.46"></stop></linearGradient>
              <linearGradient id="paint1_linear" x1="342.121" y1="120.477" x2="269"
                y2="-1.00001"
                gradientUnits="userSpaceOnUse"><stop
                  stop-color="#9EE6F7"
                  stop-opacity="0"></stop>
                <stop offset="1" stop-color="#9EE6F7" stop-opacity="0.46"></stop></linearGradient></defs></svg>
          <svg width="576" height="657" viewBox="0 0 576 657" fill="none" xmlns="http://www.w3.org/2000/svg"
            class="background-img-bottom"><path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M119.005 490.408C104.348 426.309 103.735 359.939 126.098 298.105C146.88 240.642 190.23 196.348 238.776 159.237C285.339 123.642 339.92 107.296 396.362 91.4996C468.695 71.2562 553.312 8.95396 613.046 54.4918C674.494 101.336 634.107 201.896 641.998 278.759C647.244 329.854 654.826 377.525 651.472 428.779C647.298 492.553 668.578 571.511 620.111 613.172C571.712 654.774 496.031 604.218 433.356 616.263C356.216 631.089 288.829 720.051 215.905 690.855C145.28 662.579 135.963 564.569 119.005 490.408Z"
              fill="url(#paint0_linear)"
              fill-opacity="0.3"></path>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M207.243 573.011C186.674 518.997 178.054 461.296 189.988 404.743C201.078 352.187 233.418 308.347 271.157 270.126C307.354 233.466 352.877 212.586 400.086 191.958C460.587 165.523 526.658 100.977 584.206 133.341C643.406 166.634 620.5 259.094 636.735 325.044C647.526 368.884 659.935 409.46 663.26 454.486C667.397 510.511 695.542 576.654 658.427 618.825C621.363 660.938 549.321 626.149 496.228 644.271C430.882 666.576 383.059 752.23 316.019 735.699C251.094 719.689 231.041 635.504 207.243 573.011Z"
              fill="url(#paint1_linear)"
              fill-opacity="0.4"></path>
            <path fill-rule="evenodd" clip-rule="evenodd" d="M403.49 282.211C453.064 252.494 508.362 233.896 566.131 235.735C619.816 237.444 668.646 261.602 712.889 292.059C755.324 321.272 783.858 362.431 812.44 405.295C849.068 460.228 924.193 513.966 902.414 576.295C880.011 640.412 784.967 634.064 722.882 661.603C681.612 679.91 643.839 699.238 600.092 710.401C545.658 724.291 485.472 763.592 437.449 734.441C389.492 705.33 411.119 628.307 383.973 579.211C350.563 518.785 257.854 486.712 262.381 417.812C266.766 351.086 346.134 316.591 403.49 282.211Z"
              fill="url(#paint2_linear)"
              fill-opacity="0.6"></path>
            <defs><linearGradient id="paint0_linear" x1="693.25" y1="516.469" x2="150.817"
                y2="495.802"
                gradientUnits="userSpaceOnUse"><stop
                  stop-color="#9EE6F7"
                  stop-opacity="0"></stop>
                <stop offset="1" stop-color="#9EE6F7" stop-opacity="0.46"></stop></linearGradient>
              <linearGradient id="paint1_linear" x1="710.313" y1="525.732" x2="235.594"
                y2="573.831"
                gradientUnits="userSpaceOnUse"><stop
                  stop-color="#9EE6F7"
                  stop-opacity="0"></stop>
                <stop offset="1" stop-color="#9EE6F7" stop-opacity="0.46"></stop></linearGradient>
              <linearGradient id="paint2_linear" x1="538.194" y1="769.211" x2="407.651"
                y2="310.266"
                gradientUnits="userSpaceOnUse"><stop
                  stop-color="#9EE6F7"
                  stop-opacity="0"></stop>
                <stop offset="1" stop-color="#9EE6F7" stop-opacity="0.46"></stop></linearGradient></defs></svg></div>
        <!----></div>
      <!---->
      <div class="vue-notification-group" style="width: 300px; top: 0px; right: 0px;"><span></span></div>
      <!----></div>
    
  </body>
</html>
