<template>
  <div class="proclamation card">
    <div class="title">
      <strong>系统说明</strong>
    </div>
    <div class="content">
<h1 class="ql-align-center"><span style="color: rgb(255, 255, 255); background-color: rgb(240, 102, 102);" class="ql-font-serif"> I am Example 1! </span></h1><p><br></p><p><span class="ql-font-serif">W Can a man still be brave if he's afraid? That is the only time a man can be brave. </span></p><p><br></p><p><strong class="ql-size-large ql-font-serif">Courage and folly is </strong><strong class="ql-size-large ql-font-serif" style="color: rgb(230, 0, 0);">always</strong><strong class="ql-size-large ql-font-serif"> just a fine line.</strong></p><p><br></p><p><u class="ql-font-serif">There is only one God, and his name is Death. And there is only one thing we say to Death: "Not today."</u></p><p><br></p><p><em class="ql-font-serif">Fear cuts deeper than swords.</em></p><p><br></p><pre class="ql-syntax" spellcheck="false">const a = 10; const editorOption = { highlight: text =&gt; hljs.highlightAuto(text).value }; </pre><p><br></p><p><span class="ql-font-serif">Every flight begins with a fall.</span></p><p><br></p><p><a href="https://surmon.me/" target="_blank" style="color: rgb(230, 0, 0);" class="ql-size-small ql-font-serif"><u>A ruler who hides behind paid executioners soon forgets what death is. </u></a></p><p><br></p><iframe class="ql-video ql-align-center" allowfullscreen="true" src="https://www.youtube.com/embed/QHH3iSeDBLo?showinfo=0" frameborder="0" width="560" height="238"></iframe><p><br></p><p><span class="ql-font-serif">Hear my words, and bear witness to my vow. Night gathers, and now my watch begins. It shall not end until my death. I shall take no wife, hold no lands, father no children. I shall wear no crowns and win no glory. I shall live and die at my post. I am the sword in the darkness. I am the watcher on the walls. I am the fire that burns against the cold, the light that brings the dawn, the horn that wakes the sleepers, the shield that guards the realms of men. I pledge my life and honor to the Night’s Watch, for this night and all the nights to come.</span></p><p><br></p><p><span class="ql-font-serif">We are born to suffer, to suffer can make us strong.</span></p><p><br></p><p><span class="ql-font-serif">The things we love destroy us every time.</span></p>      
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data() {
      return {};
    },
    components: {}
  };

</script>

<style scoped lang="scss">
  .proclamation {
    height: 84vh;
    padding: 20px;
    .title {
      font-size: 26px;
      font-weight: 400;
      position: relative;
      &::after {
        content: "";
        width: 100%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -10px;
        z-index: 1; //left: 1%;
        right: 1%;
      }
    }
    .content {
      margin-top: 30px;
      height: 90%;
      overflow-y: auto;
    }
  }

</style>
