/*var activeTheme=this.refs.activeTheme.getValue();//活动主题
var startTime=this.refs.startTime.getDateTime();//开始时间
var place=this.refs.place.getValue();//地点
var activeDetail=this.refs.activeDetail.getValue();//活动详情
var alarm=this.refs.alarm.getValue();
var endTime=this.refs.endTime.getValue();*/

var activeInfo={
	activeTheme:this.refs.activeTheme.getValue(),//活动主题
	startTime:this.refs.startTime.getDateTime(),//开始时间
    place:this.refs.place.getValue(),//地点
	activeDetail:this.refs.activeDetail.getValue(),//活动详情
	alarm:this.refs.alarm.getValue(),//提醒
	endTime:this.refs.endTime.getDateTime(),//结束时间
}
console.log(activeInfo);
let test=function () {
	console.log('aaa');
};
export default activeInfo