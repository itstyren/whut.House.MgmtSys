<template>
  <div class="proclamation card">
    <div class="title">
      <strong>系统说明</strong>
    </div>
    <div class="content">
      <p>新华社北京3月17日电 3月17日上午，十三届全国人大一次会议选举习近平为中华人民共和国主席消息宣布后，一些国家领导人第一时间纷纷致电或致函习近平主席，表示热烈祝贺。</p>
      <p>朝鲜国务委员会委员长金正恩表示，我对您当选为中华人民共和国主席、中华人民共和国中央军事委员会主席表示衷心祝贺，祝愿中国人民在以您为核心的中国共产党领导下，在新时代中国特色社会主义建设中取得更大成就。我确信朝中两国关系将沿着符合两国人民共同利益的方向发展。</p>
      <p>越南国家主席陈大光表示，欣闻您在第十三届全国人大一次会议上当选中华人民共和国主席和中央军委主席，我谨向您致以最热烈的祝贺。我相信，作为中共中央的领导核心、国家主席、中央军委主席，您将带领中国人民胜利实现把中国建成富强民主文明和谐美丽的社会主义现代化强国目标，为地区乃至世界和平、稳定和繁荣作出重要贡献。越南党、国家和人民高度重视发展同中国的睦邻友好与全面合作关系，视之为越南对外政策的战略选择和头等优先。相信您将继续关心指导各级、各部门落实两党两国领导人共识，不断扩大和提升两国各领域合作，推动越中全面战略合作伙伴关系持续稳定健康深入发展。</p>
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
      font-size: 21px;
      line-height: 25px;
    }
  }

</style>
